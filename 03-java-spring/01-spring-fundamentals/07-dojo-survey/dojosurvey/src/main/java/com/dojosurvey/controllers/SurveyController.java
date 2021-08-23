package com.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dojosurvey.models.Survey;


@Controller
public class SurveyController {
	private String[] getLanguages() {
		return new String[] {
			"Java", "Python", "C++"
		};
	}
	private String[] getLocations() {
		return new String[] {
			"Chicago", "Dallas", "Tulsa"
		};
	}
	@RequestMapping("/")
	public String Index(Model model) {
		model.addAttribute("locations", getLocations());
		model.addAttribute("languages", getLanguages());
		return "index.jsp";
	}
	@RequestMapping(value="/survey", method=RequestMethod.POST)
	public String Results(@RequestParam(value="name") String name, 
			@RequestParam(value="location") String location,
			@RequestParam(value="language") String language,
			@RequestParam(value="comment") String comment,
			Model model){
		model.addAttribute("result", new Survey(name, location, language, comment));
		return "result.jsp";
	}
}