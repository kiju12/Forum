package kijko.forum.validate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kijko.forum.domain.Forum;
import kijko.forum.domain.forms.ForumForm;
import kijko.forum.domain.repository.ForumRepository;
import kijko.forum.services.ForumService;



@Component
public class ForumFormValidator implements Validator {
	
	@Autowired
	private ForumService forumService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ForumForm form = (ForumForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "notEmpty");
		
		List<Forum> allForums = forumService.findAll();
		
		for(Forum f : allForums) {
			if(f.getTitle().equalsIgnoreCase(form.getName())) {
				errors.rejectValue("name", "forum.exist");
				break;
			}
		}
		
		//Ewentualne inne walidacje
	}

}
