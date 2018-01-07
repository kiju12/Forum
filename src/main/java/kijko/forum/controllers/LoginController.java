package kijko.forum.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

	private String title = "Logowanie";
	private Logger log = Logger.getLogger(LoginController.class.getName());
	
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("title", title);
		return "user/login";
	}
	
	@GetMapping("/logout")
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		HttpSession session = request.getSession(false);
		SecurityContextHolder.clearContext();
		session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		for (Cookie cookie : request.getCookies()) {
			cookie.setMaxAge(0);
		}
		
		log.info("Pomyślne wylogowanie użytkownika " + username);
		return "redirect:/";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		
		return "user/login";
	}
	

}
