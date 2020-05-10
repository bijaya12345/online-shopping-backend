package com.uwm.onlineshopping.filebinstore;

public interface StorageProvider {

	void store(String fileName, byte[] content);

    String getLocation();
}
