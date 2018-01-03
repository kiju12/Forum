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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kijko.forum.domain.forms.RegisterForm;
import kijko.forum.domain.repository.UserRepository;
import kijko.forum.validate.RegisterFormValidator;

@Controller
@RequestMapping(value="/register")
public class RegisterController {
	private static Logger log = Logger.getLogger(RegisterController.class.getName());
	
	private String title = "Rejestracja";
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RegisterFormValidator validator;
	
	@GetMapping
	public String register(Model model) {
		
		model.addAttribute("form", new RegisterForm());
		model.addAttribute("title", title);
		return "user/register";
	}
	
	@PostMapping
	public String register(@ModelAttribute("form") RegisterForm form, BindingResult result, RedirectAttributes redAtt) {
		validator.validate(form, result);
		
		if(!result.hasErrors()) {
			log.info("Formularz rejestracyjny - przeszedł walidacje");
			log.info(form.toString());
			userRepo.save(form.createUser());
			
			redAtt.addFlashAttribute("regComplete", true);
			return "redirect:/register";
		} else {
			log.info("Formularz rejestracyjny - NIE przeszedł walidacji");
			
			return "user/register";
		}
		
		
		
		
	}
	
}
