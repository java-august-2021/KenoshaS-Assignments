package com.dojo.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.dojooverflow.models.Answers;
import com.dojo.dojooverflow.models.NewQuestion;
import com.dojo.dojooverflow.models.Question;
import com.dojo.dojooverflow.services.ApplicationService;

public class QuestionsController {
	private final ApplicationService service;
	public QuestionsController(ApplicationService service) {
		this.service = service;
	}
	@GetMapping("/")
	public String Index(Model model) {
		model.addAttribute("questions", this.service.getQuestions());
		return "index.jsp";
	}
	@GetMapping("/new")
	public String New(@ModelAttribute("newQuestion") NewQuestion newQuestion) {
		return "new.jsp";
	}
	@GetMapping("/{id}")
	public String Show(@PathVariable("id") Long id, @ModelAttribute("ans") Answers ans, Model model) {
		model.addAttribute("question", this.service.getQuestion(id));
		return "show.jsp";
	}
	@PostMapping("/")
	public String Create(@Valid @ModelAttribute("newQuestion") NewQuestion newQuestion, 
		BindingResult result) {
		if(result.hasErrors())
			return "new.jsp";
		this.service.createQuestion(newQuestion);
		return "redirect:/";
	}
	@PostMapping("/answers")
	public String CreateAnswer(@Valid @ModelAttribute("answer") Answers answer, BindingResult result) {
		if(result.hasErrors())
			return "show.jsp";
		Answers newAnswer = this.service.createAnswer(answer);
		return "redirect:/" + newAnswer.getQuestion().getId();
	}

}
