package gradle_spring5_chap11.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("gradle_spring5_chap11")
public class CommonExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException() {
		return "error/commonException";
	}

}
