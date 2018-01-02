package kijko.forum.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kijko.forum.domain.forms.GroupForm;

@Component
public class GroupFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		GroupForm form = (GroupForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "crewName", "notEmpty");
		
		if(form.getCrewName().length() > 63) errors.rejectValue("crewName", "crewname.size");
		if(form.getDescription().length() > 255) errors.rejectValue("description", "description.size");
		
		String users = form.getMembers();
		//Instrukcje wyodrebniajace nazwy uzytkownikow ze Stringa
		//Instrukcje sprawdzajace czy dani uzytkownicy istnieja
		//Walidacja
	}

}
