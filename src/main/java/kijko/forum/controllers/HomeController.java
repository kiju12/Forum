package kijko.forum.controllers;

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

import kijko.forum.domain.Role;
import kijko.forum.domain.forms.ForumForm;
import kijko.forum.domain.repository.ForumRepository;
import kijko.forum.domain.repository.RoleRepository;
import kijko.forum.validate.ForumFormValidator;

@Controller
@RequestMapping("/")
public class HomeController {

	private Logger log = Logger.getLogger(HomeController.class.getName());

	private String title = "Strona główna";
	private String create_title = "Tworzenie forum";
	
	@Autowired
	private ForumRepository forumRepo;
	
	@Autowired
	private ForumFormValidator forumFormValid;
	
	@Autowired
	private RoleRepository roleRepo;

	@GetMapping
	public String home(Model model) {
		model.addAttribute("title", title);
		roleRepo.save(new Role("USER"));
		roleRepo.save(new Role("ADMIN"));
		
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
			
			forumRepo.save(form.createForum());
			redAtt.addFlashAttribute("forumCreated", true);
			
			return "redirect:/";
		} else {
			log.info("Formularz tworzenia forum - NIE UTWORZONO");
			return "admin/create_forum";
		}

	}
}
