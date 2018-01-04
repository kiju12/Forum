package kijko.forum.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kijko.forum.domain.forms.LoginForm;
import kijko.forum.domain.repository.ForumRepository;
import kijko.forum.validate.LoginFormValidator;

@Controller
public class LoginController {

	private String title = "Logowanie";
	private Logger log = Logger.getLogger(LoginController.class.getName());
	
	@Autowired
	private ForumRepository forumRepo;
	
	@Autowired
	private LoginFormValidator logFormValidator;
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("loginForm", new LoginForm());
		model.addAttribute("title", title);
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm logForm, BindingResult result, RedirectAttributes redAtt) {
		logFormValidator.validate(logForm, result);
		
		if(!result.hasErrors()) {
			log.info("Formularz logowania - pomyślne logowanie");
			redAtt.addFlashAttribute("logComplete", true);
			return "redirect:/";
		} else {
			log.info("Formularz logowania - NIE ZALOGOWANO");

			return "user/login";
		}
		
		
		
		
	}
}
