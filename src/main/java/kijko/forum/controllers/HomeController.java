package kijko.forum.controllers;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kijko.forum.domain.Forum;
import kijko.forum.domain.forms.ForumForm;
import kijko.forum.services.ForumService;
import kijko.forum.validate.ForumFormValidator;

@Controller
@RequestMapping("/")
public class HomeController {

	private Logger log = Logger.getLogger(HomeController.class.getName());

	private String title = "Strona główna";
	private String create_title = "Tworzenie forum";
	
	@Autowired
	private ForumFormValidator forumFormValid;
	
	@Autowired
	private ForumService forumService;

	@GetMapping
	public String home(Model model) {
		model.addAttribute("title", title);
		ArrayList<Forum> allForums = forumService.findAll();
		model.addAttribute("forumList", allForums);
		
		return "index";
	}
	

	@GetMapping("/createforum")
	public String createForum(Model model) {
		model.addAttribute("title", create_title);
		model.addAttribute("forumForm", new ForumForm());
		return "admin/create_forum";
	}

	@PostMapping("/createforum")
	public String createForum(@ModelAttribute("forumForm") ForumForm form, BindingResult result, Model model,
			RedirectAttributes redAtt) {
		forumFormValid.validate(form, result);

		if (!result.hasErrors()) {
			log.info("Formularz tworzenia forum - pomyślnie utworzono");
			log.info(form.toString());
			Forum created = form.createForum();
			forumService.addForum(created);
			
			redAtt.addFlashAttribute("forumCreated", true);
			
			return "redirect:/";
		} else {
			log.info("Formularz tworzenia forum - NIE UTWORZONO");
			return "admin/create_forum";
		}

	}
	
	@GetMapping("/403")
	public String error403(Model model) {
		return "error/403";
	}
}
