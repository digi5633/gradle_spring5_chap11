package gradle_spring5_chap11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gradle_spring5_chap11.dto.RegisterRequest;
import gradle_spring5_chap11.exception.DuplicateMemberException;
import gradle_spring5_chap11.service.MemberRegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private MemberRegisterService memberRegisterService;

	@RequestMapping("/step1")
	public String handleStep1() {
		return "/register/step1";
	}

	/*
		@PostMapping("/step2")
		public String handleStep2(HttpServletRequest request) {
			String agreeParam = request.getParameter("agree");
			if (agreeParam == null || !agreeParam.equals("true")) {
				return "register/step1";
			}
			return "register/step2";
		}
	*/
	@PostMapping("/step2")
	public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			RegisterRequest registerRequest) {
		if (!agree) {
			return "/register/step1";
		}
		return "/register/step2";
	}

	@GetMapping("/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}

	@PostMapping("/step3")
	public String handleStep3(RegisterRequest regReq) {
		try {
			memberRegisterService.regist(regReq);
			return "/register/step3";
		} catch (DuplicateMemberException ex) {
			return "/register/step2";
		}

	}

	@GetMapping("/step3")
	public String handleStep3Get() {
		return "redirect:/register/step1";
	}

}
