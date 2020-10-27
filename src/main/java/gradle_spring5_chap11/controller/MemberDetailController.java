package gradle_spring5_chap11.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import gradle_spring5_chap11.dao.MemberDao;
import gradle_spring5_chap11.dto.Member;
import gradle_spring5_chap11.exception.MemberNotFoundException;

@Controller
public class MemberDetailController {

	@Autowired
	private MemberDao memberDao;

	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException() {
		return "member/invalidId";
	}

	@ExceptionHandler(MemberNotFoundException.class)
	public String handeMemberNotFoundException() {
		return "member/noMember";
	}

	@GetMapping("/members/{id}")
	public ModelAndView detail(@PathVariable("id") Long memId) {

		Member member = memberDao.selectById(memId);

		if (member == null) {
			throw new MemberNotFoundException();
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName("member/memberDetail");
		return mav;
	}

}
