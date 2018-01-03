package kijko.forum.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kijko.forum.domain.forms.ThemaForm;

@Component
public class ThemaFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ThemaForm form = (ThemaForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstPostContent", "notEmpty");
		
		if(form.getTitle().length() > 63) errors.rejectValue("title", "thema.title.size");
		if(form.getFirstPostContent().length() > 2048) errors.rejectValue("firstPostContent", "thema.content.size");
	}

	
}
