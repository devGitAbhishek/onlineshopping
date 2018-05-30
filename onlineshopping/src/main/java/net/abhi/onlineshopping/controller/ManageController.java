package net.abhi.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.abhi.onlineshopping.utility.FileUploadUtility;
import net.abhi.onlineshopping.validator.ProductValidator;
import net.abhi.shoppingbackend.dao.CategoryDAO;
import net.abhi.shoppingbackend.dao.ProductDAO;
import net.abhi.shoppingbackend.dto.Category;
import net.abhi.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManageController {

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");

		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);
		
		//This condition is for logic in handleProductSubmission() when product != null
        if(operation != null) {
        	if(operation.equals("product")) {
        		mv.addObject("message", "Product added Successfully");
        	}
        }
		return mv;
	}

	//ADMIN PAGE: Handling Product Submission POst match and binding results should always come after model attribute
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product formproduct, BindingResult results, Model model,HttpServletRequest req) {
        
		
		new ProductValidator().validate(formproduct, results);
		
		//this if is written in case if form has some error it can be return to same page,-->
		//that is also the reason that redirect is not used , so that error message can be shown.
		if(results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true); 
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Product validation failed!");
			return "page";

		}
		
		//create new product record
		productDAO.add(formproduct);
		
		//file upload logic
		if(!formproduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(req,formproduct.getFile(),formproduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}

	//ADMIN PAGE: returning Category for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategoryList() {
		return categoryDAO.list();
	}
	
	//ADMIN PAGE: For saving of activation of existing product
	@RequestMapping(value="/product/{id}/activation" , method=RequestMethod.POST)
	public String activateProductHandler(@PathVariable int id) {
		
		//Fetching the product on basis of id coming from front end data table
		Product product = productDAO.get(id);
		//updating product status to true or false dependin g on their existing status
		product.setActive(!product.isActive());
		boolean isActive = product.isActive();
		productDAO.update(product);
		return (isActive)? "The product with id " + product.getId() + "is deactivated" 
						:  	 "The product with id " + product.getId() + "is activated" ;
	}

}
