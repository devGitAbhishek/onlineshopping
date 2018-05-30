package net.abhi.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.abhi.shoppingbackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		// handler for not uploading file
		Product formProduct = (Product) target;
		if (formProduct.getFile().getOriginalFilename().equals("") || formProduct.getFile() == null) {
			errors.rejectValue("file", null, "Please upload file to proceed further!");
		   return;
		}

		// handler for checking format of file
		if (formProduct.getFile().getContentType().equals("/image/png")
				|| formProduct.getFile().getContentType().equals("/image/jpeg")
				|| formProduct.getFile().getContentType().equals("/image/gif")) {
             
			errors.rejectValue("file", null, "Please upload only Jpeg, png and GIF formats file!");
			return;
			
			
		}

	}

}
