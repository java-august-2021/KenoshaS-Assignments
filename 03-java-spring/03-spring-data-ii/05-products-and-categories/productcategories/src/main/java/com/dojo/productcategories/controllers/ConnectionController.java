package com.dojo.productcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.productcategories.models.Connection;
import com.dojo.productcategories.services.ApplicationService;

@Controller
public class ConnectionController {
		private final ApplicationService appService;
		public ConnectionController(ApplicationService service) {
			this.appService = service;
		}
		@PostMapping("/connections/{kind}")
		public String Create(@Valid @ModelAttribute("connection") Connection connection,
				BindingResult result,
				@PathVariable("kind") String kind) {
			if(result.hasErrors())
				return String.format("/%s/show.jsp", kind);
			appService.createConnection(connection);
			return "redirect:/";
		}
		

	}

