package net.abhi.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.abhi.shoppingbackend.dao.CategoryDAO;
import net.abhi.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO cat;

	// INFO 1 : For test purpose to check if @RequestParam and @PathVariable are
	// working in project module --> Verified.
	/*
	 * @RequestMapping(value = "/test") public ModelAndView test(@RequestParam(value
	 * = "greeting",required = false)String greeting) {
	 * 
	 * if(greeting == null) { greeting = "Hello there!"; }
	 * System.out.println("greeting " +greeting); ModelAndView mv = new
	 * ModelAndView("page"); mv.addObject("greeting",greeting); return mv; }
	 * 
	 * @RequestMapping(value = "/test/{greeting}") public ModelAndView
	 * test(@PathVariable("greeting")String greeting) {
	 * 
	 * if(greeting == null) { greeting = "Hello there!"; }
	 * System.out.println("greeting " +greeting); ModelAndView mv = new
	 * ModelAndView("page"); mv.addObject("greeting",greeting); return mv; }
	 */

	// Project work will started from here all the logics and project comments will
	// be written here.

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting", "Welcome to Spring");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		mv.addObject("categories", cat.list());
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView aboutCompany() {

		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting", "Welcome to Spring");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contactOfCompany() {

		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting", "Welcome to Spring");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	/**
	 * Method to load all the products and product based on category
	 */

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showListOfProducts() {
		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting", "Welcome to Spring");
		mv.addObject("title", "All Products");
		mv.addObject("categories", cat.list());
		mv.addObject("userClickProducts", true);
		return mv;
	}

	// parameter inside this {} governs dynamic thing
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryOfProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// CategoryDAO to fetch single category
		Category category = null;
		category = cat.get(id);
		// Passing category title
		mv.addObject("title", category.getName());
		// Passing category list of object
		mv.addObject("categories", cat.list());
		// Passing category object
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

}
