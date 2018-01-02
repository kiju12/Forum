package kijko.forum.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kijko.forum.domain.forms.RegisterForm;

@Component
public class RegisterFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterForm form = (RegisterForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "notEmpty");
		if(form.getUsername().length() < 6 || form.getUsername().length() > 12) 
			errors.rejectValue("username", "username.size");
		
		//Tutaj warunek że username nie wystepuje w bazie danych
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "notEmpty");
		if(form.getUsername().length() < 5 || form.getUsername().length() > 24)
			errors.rejectValue("password", "password.size");
		
		if(!form.getPassword().equals(form.getPassConfirm())) {
			errors.rejectValue("passConfirm", "passConfirm.diff");
		}
		
		ValidationUtils.rejectIfEmpty(errors, "email", "notEmpty");
		if(!form.getEmail().contains("@"))
			errors.rejectValue("email", "email.monkey");
		
		
	}

}
