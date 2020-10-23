package gradle_spring5_chap11.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import gradle_spring5_chap11.dto.RegisterRequest;

public class RegisterRequestValidator implements Validator {

	private static final String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;

	public RegisterRequestValidator() {
		this.pattern = Pattern.compile(emailRegExp);
	}

	//
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	// pa
	@Override
	public void validate(Object target, Errors errors) {

		RegisterRequest regReq = (RegisterRequest) target;
		// email validation
		if (regReq.getEmail() == null || regReq.getEmail().trim().isEmpty()) {
			// rejectValue(String field, String errorCode);
			errors.rejectValue("email", "required"); // 에러 코드 저장
		} else {
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "bad"); // 에러 코드 저장
			}

		}
		// rejectIfEmptyOrWhitespace(Errors errors, String field, String errorCode)
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");

		// rejectIfEmpty(Errors errors, String field, String errorCode)
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");

		if (!regReq.getPassword().isEmpty()) {
			if (!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}

		}

	}

}
