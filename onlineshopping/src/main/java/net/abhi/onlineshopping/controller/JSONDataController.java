package net.abhi.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.abhi.shoppingbackend.dao.ProductDAO;
import net.abhi.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JSONDataController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProductList(){
		return productDAO.list();
	}
	
	@RequestMapping("/manage/all/products")
	@ResponseBody
	public List<Product> getAdminProductList(){
		return productDAO.list();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductListByCategory(@PathVariable int id){
		return productDAO.getlistActiveProductsByCategory(id);
	}
	
	
}
