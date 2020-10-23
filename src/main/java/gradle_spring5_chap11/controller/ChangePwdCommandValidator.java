package gradle_spring5_chap11.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import gradle_spring5_chap11.dto.ChangePwdCommand;

public class ChangePwdCommandValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ChangePwdCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPasswordf", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPassword", "required");
	}

}
