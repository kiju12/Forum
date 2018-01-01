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

import kijko.forum.domain.GroupForm;

@Controller
@RequestMapping("/groups")
public class GroupsController {
	private Logger log = Logger.getLogger(GroupsController.class.getName());
	
	private String main_title = "Grupy";
	private String group_title = "Strona grupy";
	private String createGroup = "Tworzenie grupy";
	
	@Autowired
	private GroupForm createGroupForm;
	
	@GetMapping
	public String groups(Model model) {
		model.addAttribute("title", main_title);
		return "domain/groups";
	}
	
	@GetMapping("/groupsite")
	public String groupsite(Model model) {
		model.addAttribute("title", group_title);
		return "group/group_site";
	}
	
	@GetMapping("/creategroup")
	public String createGroup(Model model) {
		model.addAttribute("title", createGroup);
		model.addAttribute("groupForm", createGroupForm);
		return "group/create_group";
	}
	
	@PostMapping("/creategroup")
	public String createGroup(@ModelAttribute("createGroupForm") GroupForm form, BindingResult result) {
		log.info(form.toString());
		return "group/create_group";
	}
}
