package com.uwm.onlineshopping.service;

import java.io.IOException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uwm.onlineshopping.exception.DataAlreadyExistsException;
import com.uwm.onlineshopping.exception.DataCorruptedException;
import com.uwm.onlineshopping.filebinstore.StorageProvider;
import com.uwm.onlineshopping.model.FileMetaData;
import com.uwm.onlineshopping.repository.FileMetaDataRepository;

@Service
public class FileServiceImpl implements FileService {

	private final StorageProvider storageProvider;
	private final FileMetaDataRepository fileMetaDataRepository;

	@Autowired
	public FileServiceImpl(FileMetaDataRepository fileMetaDataRepository, StorageProvider storageProvider) {
		this.fileMetaDataRepository = fileMetaDataRepository;
		this.storageProvider = storageProvider;
	}

	@Transactional
	public FileMetaData storeData(MultipartFile file, String title, String details) {
		String fileName = file.getOriginalFilename();
		Optional<FileMetaData> metadataFromDb = fileMetaDataRepository.findById(fileName);
		if (metadataFromDb.isPresent()) {
			throw new DataAlreadyExistsException("File with name " + fileName + " has been already uploaded");
		}
		String location = getTargetFileLocation(file.getOriginalFilename());
		FileMetaData savedData = fileMetaDataRepository.save(extractMetadata(file, title, details, location));
		byte[] content = extractContent(file);
		storageProvider.store(file.getOriginalFilename(), content);
		return savedData;
	}

	public Page<FileMetaData> getAllMetaData(Pageable pageable) {
		return fileMetaDataRepository.findAll(pageable);
	}

	private FileMetaData extractMetadata(MultipartFile file, String title, String details, String location) {
		FileMetaData fileMetaData = new FileMetaData();
		fileMetaData.setContentSize(file.getSize());
		fileMetaData.setName(file.getOriginalFilename());
		fileMetaData.setContentType(file.getContentType());
		fileMetaData.setDetails(details);
		fileMetaData.setTitle(title);
		fileMetaData.setCreatedAt(System.currentTimeMillis());
		fileMetaData.setLocation(location);
		return fileMetaData;
	}

	private byte[] extractContent(MultipartFile file) {
		try {
			return file.getBytes();
		} catch (IOException e) {
			throw new DataCorruptedException(e);
		}
	}

	private String getTargetFileLocation(String originalFilename) {
		return storageProvider.getLocation() + "/" + originalFilename;
	}
}
