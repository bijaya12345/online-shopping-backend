package com.uwm.onlineshopping.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.uwm.onlineshopping.model.FileMetaData;

public interface FileService {

	FileMetaData storeData(MultipartFile file, String title, String details);

	Page<FileMetaData> getAllMetaData(Pageable pageable);
}
