package net.yummycode.jsfplate.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "emailAddressValidator")
public class EmailAddressValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		boolean valid = true;
		/*
		String email = String.valueOf(value);
		if (value == null) {
			valid = false;
		} else if (!email.contains("@")) {
			valid = false;
		} else if (!email.contains(".")) {
			valid = false;
		} else if (email.contains(" ")) {
			valid = false;
		}
		*/
		if (!valid) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Invalid email address",
					"The email address you entered is not valid.");
			throw new ValidatorException(message);
		}
	}

}
