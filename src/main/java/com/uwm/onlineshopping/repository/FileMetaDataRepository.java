package com.uwm.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uwm.onlineshopping.model.FileMetaData;

@Repository
public interface FileMetaDataRepository extends JpaRepository<FileMetaData, String> {
}
