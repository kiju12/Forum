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

import kijko.forum.domain.forms.AnswerForm;
import kijko.forum.domain.forms.ThemaForm;
import kijko.forum.validate.AnswerFormValidator;
import kijko.forum.validate.ThemaFormValidator;

@Controller
@RequestMapping("/forums")
public class ForumController {
	
	private Logger log = Logger.getLogger(ForumController.class.getName());
	
	@Autowired
	private ThemaFormValidator themaFormValidator;
	
	@Autowired
	private AnswerFormValidator answerFormValid;
	
	@GetMapping("/example")
	public String forum(Model model) {
		model.addAttribute("title", "Przykladowe Forum");
		return "domain/forum";
	}
	
	
	@GetMapping("/example/createthema")
	public String createThema(Model model) {
		model.addAttribute("themaForm", new ThemaForm());
		model.addAttribute("title", "Tworzenie tematu");
		return "user/create_thema";
	}
	
	@PostMapping("/example/createthema")
	public String createThema(@ModelAttribute("themaForm") ThemaForm form, BindingResult result, Model model, RedirectAttributes redAtt) {
		themaFormValidator.validate(form, result);
		
		if(!result.hasErrors()) {
			log.info("Formularz tematu - pomyślnie utworzony");
			log.info(form.toString());
			
			redAtt.addFlashAttribute("themaCreated", true);
			return "redirect:/forums/example";
		} else {
			log.info("Formularz tematu - NIE UTWORZONY");
			return "user/create_thema";
		}
	}
	
	@GetMapping("/example/thema")
	public String thema(Model model) {
		model.addAttribute("formAnswer", new AnswerForm());
		return "domain/thema";
		
	}
	
	@PostMapping("/example/thema")
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