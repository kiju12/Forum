package kijko.forum.controllers;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kijko.forum.domain.Forum;
import kijko.forum.domain.Post;
import kijko.forum.domain.Thema;
import kijko.forum.domain.User;
import kijko.forum.domain.forms.AnswerForm;
import kijko.forum.domain.forms.ThemaForm;
import kijko.forum.services.ForumService;
import kijko.forum.services.UserService;
import kijko.forum.validate.AnswerFormValidator;
import kijko.forum.validate.ThemaFormValidator;

@Controller
@RequestMapping("/forums")
public class ForumController {
	
	private Logger log = Logger.getLogger(ForumController.class.getName());
	
	@Autowired
	private ForumService forumService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ThemaFormValidator themaFormValidator;
	
	@Autowired
	private AnswerFormValidator answerFormValid;
	
	@GetMapping("/{forumTitle}")
	public String forum(@PathVariable("forumTitle") String forumTitle, Model model) {
		
		
		Forum forum = forumService.findByTitle(forumTitle);
		
		if(forum == null) {
			return "redirect:/";
		} else {
			model.addAttribute("title", forumTitle);
			
			List<Thema> themaList = forum.getThemas();
			model.addAttribute("themaList", themaList);
			
			return "domain/forum";
		}
		
		
	}
	
	
	@GetMapping("/{forumTitle}/createthema")
	public String createThema(@PathVariable("forumTitle") String forumTitle, Model model) {
		Forum forum = forumService.findByTitle(forumTitle);
		
		if(forum == null) {
			log.info("Nie znaleziono forum: " + forumTitle);
			return "redirect:/";
		} else {
			model.addAttribute("themaForm", new ThemaForm());
			model.addAttribute("title", "Tworzenie tematu na forum " + forumTitle);
			model.addAttribute("forumTitle", forumTitle);
			
			return "user/create_thema";
		}
		
		
		
	}
	
	@PostMapping("/{forumTitle}/createthema")
	public String createThema(@ModelAttribute("themaForm") ThemaForm form, @PathVariable("forumTitle") String forumTitle, 
			BindingResult result, RedirectAttributes redAtt) {
		themaFormValidator.validate(form, result);
		
		Forum forum = forumService.findByTitle(forumTitle);
		String author = SecurityContextHolder.getContext().getAuthentication().getName();
		
		if(!result.hasErrors() && forum != null && author != null) {
			log.info("Formularz tematu - pomyślnie utworzony");
			log.info(form.toString());
			
			Thema created = form.createThema();
			
			User themaAuthor = userService.findByLogin(author);
				created.setAuthor(themaAuthor);
			
			Post firstPost = new Post();
				firstPost.setDateOfCreate(new Date());
				firstPost.setAuthor(themaAuthor);
				firstPost.setContent(form.getFirstPostContent());
			
			created.getPosts().add(firstPost);
				
			forum.getThemas().add(created);
			
			forumService.updateForum(forum);
			
			
			redAtt.addFlashAttribute("themaCreated", true);
			return "redirect:/forums/" + forumTitle;
		} else {
			log.info("Formularz tematu - NIE UTWORZONY");
			return "user/create_thema";
		}
	}
	
	@GetMapping("/{forumTitle}/{themaTitle}")
	public String thema(@PathVariable("forumTitle") String forumTitle, @PathVariable("themaTitle") String themaTitle, Model model) {
		Forum forum = forumService.findByTitle(forumTitle);
		Thema thema = null;
		
		if(forum != null) {
			thema = forum.getOneThema(themaTitle);
			
		}
		if(forum != null && thema != null) {
			
			model.addAttribute("title", themaTitle);
			model.addAttribute("forumTitle", forumTitle);
			model.addAttribute("themaTitle", themaTitle);
			model.addAttribute("postList", thema.getPosts());
			model.addAttribute("formAnswer", new AnswerForm());
			return "domain/thema";
		
		} else {
			log.info("Nie znaleziono tematu");
			
			return "redirect:/";
		}
		
		
		
		
		
	}
	
	@PostMapping("/{forumTitle}/{themaTitle}")
	public String themaAnswer(@ModelAttribute("formAnswer") AnswerForm form, BindingResult result) {
		answerFormValid.validate(form, result);
		
		if(!result.hasErrors()) {
			log.info("Formularz odpowiedzi - pomyślnie utworzony");
			log.info(form.toString());
			
			return "redirect:/forums/example/thema";
		} else {
			log.info("Formularz odpowiedzi - NIE UTWORZONO");
		}
		
		return "domain/thema";
	}
}
