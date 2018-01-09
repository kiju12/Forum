package kijko.forum.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kijko.forum.domain.forms.RegisterForm;
import kijko.forum.services.UserService;

@Component
public class RegisterFormValidator implements Validator {
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterForm form = (RegisterForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "notEmpty");
		if(form.getUsername().length() < 6 || form.getUsername().length() > 20) 
			errors.rejectValue("username", "username.size");
		
		//Tutaj warunek że username nie wystepuje w bazie danych
			if(userService.findByLogin(form.getUsername()) != null) {
				errors.rejectValue("username", "username.duplication");
			}
			
			if(userService.findByEmail(form.getEmail()) != null) {
				errors.rejectValue("email", "email.duplication");
			}
		
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
