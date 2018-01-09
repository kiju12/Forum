package kijko.forum.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kijko.forum.domain.Forum;
import kijko.forum.domain.Post;
import kijko.forum.domain.Thema;
import kijko.forum.domain.User;
import kijko.forum.services.ForumService;
import kijko.forum.services.UserService;

@Controller
@RequestMapping("/adminpanel")
public class AdminController {
	
	private Logger log = Logger.getLogger(AdminController.class.getName());
	
	@Autowired
	private ForumService forumService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String adminPanel(Model model) {
		model.addAttribute("forumList", forumService.findAll());
		model.addAttribute("usersList", userService.findAll());
		return "admin/adminpanel";
	}
	
	@GetMapping("/delete/user/{username}")
	public String deleteUser(@PathVariable("username") String username, RedirectAttributes redAtts) {
		
		User user = userService.findByLogin(username);
		
		if(user == null) {
			log.info("Nie znaleziono użytkownika: " + username);
			redAtts.addFlashAttribute("deletingUser", false);
		} else {
			
			log.info("Usuwanie użytkownika " + username);
			userService.deleteUser(user);
			redAtts.addFlashAttribute("deletedUsername", username);
			redAtts.addFlashAttribute("deletingUser", true);
		}
		
		return "redirect:/adminpanel";
	}
	
	@GetMapping("/delete/forum/{forumTitle}")
	public String deleteForum(@PathVariable("forumTitle") String forumTitle,
			RedirectAttributes redAtts) {
		Forum forum = forumService.findByTitle(forumTitle);
		
		if(forum == null) {
			log.info("Nie znaleziono forum: " + forumTitle);
			redAtts.addFlashAttribute("deletingForum", false);
		} else {
			log.info("Usuwanie forum: " + forumTitle);
			forumService.deleteForum(forum);
			redAtts.addFlashAttribute("deletingForum", true);
			redAtts.addFlashAttribute("deletedForumTitle", forumTitle);
		}
		
			return "redirect:/adminpanel";
	}
	
	@GetMapping("/delete/forum/thema/{forumTitle}-{themaTitle}")
	public String deleteThema(@PathVariable("forumTitle") String forumTitle, 
			@PathVariable("themaTitle") String themaTitle, RedirectAttributes redAtts) {
		
		Forum forum = forumService.findByTitle(forumTitle);
		Thema thema = null;
		
		if(forum != null && forum.hasThema(themaTitle)) {
			log.info("Znaleziono temat " + themaTitle + " na forum " + forumTitle);
			thema = forum.getOneThema(themaTitle);
		} else {
			log.info("Nie znaleziono forum lub tematu w forum");
			redAtts.addFlashAttribute("themaDeleted", false);
			return "redirect:/";
		}
		
		forum.getThemas().remove(thema);
		forumService.updateForum(forum);
		log.info("Pomyslne usuniecie tematu " + themaTitle + " z forum " + forumTitle);
		redAtts.addFlashAttribute("deletedTitle", themaTitle);
		redAtts.addFlashAttribute("themaDeleted", true);
		return "redirect:/forums/" + forumTitle;
	}
	
	@GetMapping("/delete/forum/thema/post/{forumTitle}-{themaTitle}-{postId}")
	public String deletePost(@PathVariable("forumTitle") String forumTitle, @PathVariable("themaTitle") String themaTitle,
			@PathVariable("postId") Long postId, RedirectAttributes redAtts) {
		
		Forum forum = forumService.findByTitle(forumTitle);
		Thema thema = null;
		
		if(forum != null && forum.hasThema(themaTitle)) {
			log.info("Znaleziono temat " + themaTitle + " na forum " + forumTitle);
			thema = forum.getOneThema(themaTitle);
			
			if(thema.hasPost(postId)) {
				log.info("Znaleziono post o ID " + postId + " w temacie " + themaTitle + "[" + forumTitle + "]");
				
				Post post = thema.getPostById(postId);
				thema.getPosts().remove(post);
				
				forumService.updateForum(forum);
				
				log.info("Pomyślnie usunięto post " + postId);
				redAtts.addFlashAttribute("postDeleted", true);
				redAtts.addFlashAttribute("deletedAuthor", post.getAuthor().getLogin());
			} else {
				log.info("Nie znaleziono posta o ID " + postId + " w temacie " + themaTitle + "[" + forumTitle + "]");
				redAtts.addFlashAttribute("postDeleted", false);
			}
			
			return "redirect:/forums/" + forumTitle + "/" + themaTitle;
			
		} else {
			log.info("Nie znaleziono forum lub tematu w forum");
			return "redirect:/";
		}
		
	}
	
}
