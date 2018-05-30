package net.abhi.onlineshopping.exception;

import java.io.Serializable;

public class ProductNotFindException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
 public ProductNotFindException() {
	 this("Product is not found");
	 
 }

public ProductNotFindException(String msg) {
 this.message = System.currentTimeMillis() + ":" +msg;
}

public String getMessage() {
	
	return message;
}
 
}
