package kijko.forum.validate;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kijko.forum.domain.LoginForm;
import kijko.forum.domain.User;
import kijko.forum.domain.repository.UserRepository;

@Component
public class LoginFormValidator implements Validator {

	@Autowired
	private UserRepository rep;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginForm lForm = (LoginForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "notEmpty" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "notEmpty" );
		
		ArrayList<User> allUsers = rep.getUsers();
		User lookedFor = null;
		
		//Wyszukanie użytkownika
		for(User u : allUsers) {
			if( u.getLogin().equals(lForm.getLogin()) ){
				
				lookedFor = u;
				
				if(! lookedFor.getPassword().equals(lForm.getPassword()) ) {
					errors.rejectValue("password", "password.bad");
				}
				break;
				
			}
		}
		
		if(lookedFor == null) {
			errors.rejectValue("login", "login.bad");
		}
		
	}

	
}
