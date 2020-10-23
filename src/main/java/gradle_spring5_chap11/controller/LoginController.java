package gradle_spring5_chap11.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gradle_spring5_chap11.dto.AuthInfo;
import gradle_spring5_chap11.dto.LoginCommand;
import gradle_spring5_chap11.exception.WrongIdPasswordException;
import gradle_spring5_chap11.service.AuthService;

@Controller
@RequestMapping("/login")
public class LoginController {

	/*@GetMapping("/login")
	public String form(Login login) {
		return "login/form";
	}
	
	@PostMapping("/result")
	public String result(@ModelAttribute("login") Login login) {
		return "login/result";
	}
	
	@ModelAttribute("loginTypes")
	public List<String> getLoginTypes() {
		List<String> loginTypes = new ArrayList<>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");
		return loginTypes;
	}
	
	@ModelAttribute("jobCodes")
	public List<Code> getJobCodes() {
		List<Code> jobCodes = new ArrayList<>();
		jobCodes.add(new Code("A", "사용자"));
		jobCodes.add(new Code("B", "개발자"));
		jobCodes.add(new Code("C", "관리자"));
		return jobCodes;
	}
	
	@ModelAttribute("tools")
	public List<String> getTools() {
		List<String> tools = new ArrayList<>();
		tools.add("Eclipse");
		tools.add("IntelliJ");
		tools.add("VSCode");
		return tools;
	}
	
	@ModelAttribute("favoriteOsNames")
	public List<String> getFavoriteOs() {
		List<String> favoriteOs = new ArrayList<>();
		favoriteOs.add("윈도우10");
		favoriteOs.add("리눅스");
		favoriteOs.add("유닉스");
		favoriteOs.add("칼리리눅스");
		favoriteOs.add("우분투");
		return favoriteOs;
	}
	
	@ModelAttribute("likeOsNames")
	public List<String> getLikeOs() {
		List<String> likeOs = new ArrayList<>();
		likeOs.add("윈도우10");
		likeOs.add("리눅스");
		likeOs.add("유닉스");
		likeOs.add("칼리리눅스");
		likeOs.add("우분투");
		return likeOs;
	}*/

	@Autowired
	private AuthService authService;

	@GetMapping
	public String form(LoginCommand loginCommand) {
		return "login/loginForm";
	}

	@PostMapping
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session) {
		
		new LoginCommandValidator().validate(loginCommand, errors);
		
		if (errors.hasErrors())
			return "login/loginForm";
		try {
			AuthInfo authInfo = authService.authenicate(loginCommand.getEmail(), loginCommand.getPassword());
			session.setAttribute("authInfo", authInfo);
			return "login/loginSuccess";
		} catch (WrongIdPasswordException ex) {
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}

	}

}
