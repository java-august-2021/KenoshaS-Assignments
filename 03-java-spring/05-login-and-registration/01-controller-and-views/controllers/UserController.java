package com.dojo.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dojo.authentication.models.User;
import com.dojo.authentication.services.UserService;
import com.dojo.authentication.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;
    
    
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @GetMapping("/")
    	public String registrationForm(@ModelAttribute("user") User user) {
    		return "index.jsp";
    	
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "index.jsp";
        }
        User newUser = userService.registerUser(user);
        session.setAttribute("userId", newUser.getId());
        return "homePage.jsp";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redir) {
    	if(this.userService.authenticateUser(email, password)) {
    		User user = this.userService.findByEmail(email);
    		session.setAttribute("userId", user.getId());
    		return "redirect:/home";
    	} else {
    		model.addAttribute("error", "Invalid Credentials, Please try again." );
    		return "redirect:/";
    	}
    	
    	
    
    }
     
//    @RequestMapping("/home")
//    public String home(HttpSession session, Model model) {
//    	Long userId = (Long) session.getAttribute(userId);
//    	User user = userService.findUserById(userId);
//    	model.addAttribute("User", user);
//    	return "homePage.jsp";
//        // get user from session, save them in the model and return the home page
//    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	
    	return "redirect:/";
    	
    }
}