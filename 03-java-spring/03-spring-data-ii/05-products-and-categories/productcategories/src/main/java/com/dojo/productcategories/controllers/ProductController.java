package com.dojo.productcategories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.dojo.productcategories.models.Connection;
import com.dojo.productcategories.models.Category;
import com.dojo.productcategories.models.Product;
import com.dojo.productcategories.services.ApplicationService;

public class ProductController {
	private ApplicationService appService;
	public ProductController(ApplicationService service) {
		this.appService = service;
	}
	@GetMapping("/")
	public String Index(Model model) {
		model.addAttribute("products", appService.findProducts());
		return "/index.jsp";
	}
	@GetMapping("/{id}")
	public String Show(@ModelAttribute("connection") Connection connection, 
		@PathVariable("id") Long id, Model model) {
		Product thisOne = appService.getProduct(id);
		List<Category> others = appService.findCategoriesNotInProduct(thisOne);
		model.addAttribute("product", thisOne);
		model.addAttribute("notInCategories", others);
		return "/show.jsp";
	}

}
