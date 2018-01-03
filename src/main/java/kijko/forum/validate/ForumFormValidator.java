package kijko.forum.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



@Component
public class ForumFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		//ForumForm form = (ForumForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "notEmpty");
		
		//Ewentualne inne walidacje
	}

}
