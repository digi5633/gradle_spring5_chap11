package gradle_spring5_chap11.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import gradle_spring5_chap11.dao.MemberDao;
import gradle_spring5_chap11.dto.Member;
import gradle_spring5_chap11.dto.RegisterRequest;
import gradle_spring5_chap11.exception.DuplicateMemberException;

@Component
public class MemberRegisterService {

	private MemberDao memberDao;

	@Autowired
	// 생성자를 통해 의존 객체를 주입 받음
	public MemberRegisterService(MemberDao memberDao) {
		// 주입 받은 객체를 필드에 할당
		this.memberDao = memberDao;
	}

	public Long regist(RegisterRequest req) {
		// 주입 받은 의존 객체를 메서드를 사용
		Member member = null;

		try {
			member = memberDao.selectByEmail(req.getEmail());
			if (member != null) {
				throw new DuplicateMemberException("dup email " + req.getEmail());
			}
		} catch (EmptyResultDataAccessException e) {

		}

		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();

	}

}
