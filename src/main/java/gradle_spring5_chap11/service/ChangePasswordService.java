package gradle_spring5_chap11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gradle_spring5_chap11.dao.MemberDao;
import gradle_spring5_chap11.dto.Member;
import gradle_spring5_chap11.exception.MemberNotFoundException;

@Component
public class ChangePasswordService {

	private MemberDao memberDao;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Transactional
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);

		if (member == null) {
			throw new MemberNotFoundException();
		}

		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);

	}

}
