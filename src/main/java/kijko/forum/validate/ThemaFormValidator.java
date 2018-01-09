package kijko.forum.validate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kijko.forum.domain.Forum;
import kijko.forum.domain.Thema;
import kijko.forum.domain.forms.ThemaForm;
import kijko.forum.services.ForumService;

@Component
public class ThemaFormValidator implements Validator {
	
	@Autowired
	private ForumService forumService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ThemaForm form = (ThemaForm) target;
		
		Forum forumOfThema = forumService.findByTitle(form.getForumTitle());
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstPostContent", "notEmpty");
		
		if(form.getTitle().length() > 63) errors.rejectValue("title", "thema.title.size");
		if(form.getFirstPostContent().length() > 2048) errors.rejectValue("firstPostContent", "thema.content.size");
		
		List<Thema> allThemas = forumOfThema.getThemas();
		
		for(Thema t : allThemas) {
			if(t.getTitle().equalsIgnoreCase(form.getTitle())) {
				errors.rejectValue("title", "thema.exist");
			}
		}
		
	}

	
}
