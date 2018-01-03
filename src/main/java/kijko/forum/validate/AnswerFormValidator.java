package kijko.forum.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kijko.forum.domain.forms.AnswerForm;

@Component
public class AnswerFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "notEmpty");
		
		AnswerForm form = (AnswerForm) target;
		
		if(form.getContent().length() > 2048) errors.rejectValue("content", "answer.size");
		
	}

	
}
