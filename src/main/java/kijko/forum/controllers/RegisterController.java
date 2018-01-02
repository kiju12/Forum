package kijko.forum.controllers;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kijko.forum.domain.User;
import kijko.forum.domain.forms.RegisterForm;
import kijko.forum.domain.repository.UserRepository;
import kijko.forum.validate.RegisterFormValidator;

@Controller
@RequestMapping(value="/register")
public class RegisterController {
	private static Logger log = Logger.getLogger(RegisterController.class.getName());
	
	private String title = "Rejestracja";
	private boolean regComplete = false;
	
	@Autowired
	private UserRepository rep;
	
	@Autowired
	private RegisterFormValidator validator;
	
	@GetMapping
	public String register(Model model) {
		
		model.addAttribute("form", new RegisterForm());
		model.addAttribute("title", title);
		return "user/register";
	}
	
	//Informacje po rejestracji
	@PostMapping
	public String register(@ModelAttribute("form") RegisterForm form, BindingResult result, Model model) {
		validator.validate(form, result);
		User registered;
		
		if(!result.hasErrors()) {
			log.info("Formularz przeszedł walidacje");
			
			regComplete = true;
			
			registered = form.createUser();	
			rep.addUser(registered);
			registered.print();
			
			
		} else {
			log.info("Formularz nie przeszedł walidacji");
			
			regComplete = false;
			
		}
		
		
		model.addAttribute("regComplete", regComplete);
		return "user/register";
		
	}
	
}
