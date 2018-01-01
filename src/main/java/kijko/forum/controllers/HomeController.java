package kijko.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	private String title = "Strona główna";
	
	@GetMapping(value="/")
	public String home(Model model) {
		model.addAttribute("title", title);
		
		return "index";
	}
}
