package gradle_spring5_chap11.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import gradle_spring5_chap11.dto.Login;

@Controller
public class LoginController {

	@GetMapping("/login")
	public ModelAndView form() {
		List<String> loginTypes = new ArrayList<>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");
		ModelAndView mav = new ModelAndView("login/loginForm", "loginTypes", loginTypes);
		return mav;
	}

	@PostMapping("/result")
	public String result(@ModelAttribute("login") Login login) {
		return "login/result";

	}

}
