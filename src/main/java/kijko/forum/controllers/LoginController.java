package kijko.forum.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kijko.forum.domain.forms.LoginForm;
import kijko.forum.validate.LoginFormValidator;

@Controller
public class LoginController {

	private String title = "Logowanie";
	private boolean logComplete = false;
	private Logger log = Logger.getLogger(LoginController.class.getName());
	
	@Autowired
	private LoginFormValidator logFormValidator;
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("loginForm", new LoginForm());
		model.addAttribute("title", title);
		return "user/login";
	}
	
	//Informacje po logowaniu
	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm logForm, BindingResult result, Model model) {
		logFormValidator.validate(logForm, result);
		
		if(!result.hasErrors()) {
			log.info("Pomyślne logowanie");
			logComplete = true;
			model.addAttribute("logComplete", logComplete);
			return "/";
		} else {
			log.info("Błąd w logowaniu");
			logComplete = false;
			model.addAttribute("logComplete", logComplete);
			return "user/login";
		}
		
		
		
		
	}
}
