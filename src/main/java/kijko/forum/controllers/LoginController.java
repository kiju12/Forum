package kijko.forum.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kijko.forum.domain.forms.LoginForm;
import kijko.forum.validate.LoginFormValidator;

@Controller
public class LoginController {

	private String title = "Logowanie";
	private Logger log = Logger.getLogger(LoginController.class.getName());
	
//	@Autowired
//	private ForumRepository forumRepo;
	
	@Autowired
	private LoginFormValidator logFormValidator;
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("loginForm", new LoginForm());
		model.addAttribute("title", title);
		return "user/login";
	}
	
	@GetMapping("/logout")
	public String logoutDo(HttpServletRequest request,HttpServletResponse response){
	HttpSession session= request.getSession(false);
	    SecurityContextHolder.clearContext();
	         session= request.getSession(false);
	        if(session != null) {
	            session.invalidate();
	        }
	        for(Cookie cookie : request.getCookies()) {
	            cookie.setMaxAge(0);
	        }

	    return "redirect:/";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		
		return "user/login";
	}
	
//	@PostMapping("/login")
//	public String login(@ModelAttribute("loginForm") LoginForm logForm, BindingResult result, RedirectAttributes redAtt) {
//		logFormValidator.validate(logForm, result);
//		
//		if(!result.hasErrors()) {
//			log.info("Formularz logowania - pomyślne logowanie");
//			redAtt.addFlashAttribute("logComplete", true);
//			return "redirect:/";
//		} else {
//			log.info("Formularz logowania - NIE ZALOGOWANO");
//
//			return "user/login";
//		}
//		
//		
//		
//		
//	}
}
