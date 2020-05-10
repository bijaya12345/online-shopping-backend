package com.uwm.onlineshopping.exception;

public class DataCorruptedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataCorruptedException(Throwable thr) {
		super(thr);
	}
}