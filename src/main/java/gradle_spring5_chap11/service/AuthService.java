package gradle_spring5_chap11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gradle_spring5_chap11.dao.MemberDao;
import gradle_spring5_chap11.dto.AuthInfo;
import gradle_spring5_chap11.dto.Member;
import gradle_spring5_chap11.exception.WrongIdPasswordException;

@Component
public class AuthService {

	@Autowired
	private MemberDao memberDao;

	public AuthInfo authenicate(String email, String password) {
		
		Member member = memberDao.selectByEmail(email);
		
		if (member == null) {
			throw new WrongIdPasswordException();
		}
		
		if (!member.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(member.getId(), member.getEmail(), member.getName());
	}

}
