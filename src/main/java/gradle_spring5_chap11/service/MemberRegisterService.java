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
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Long regist(RegisterRequest req) {

		Member member = null;
		try {
			member = memberDao.selectByEmail(req.getEmail());
			if (member != null) {
				throw new DuplicateMemberException("dup email " + req.getEmail());
			}
		} catch (EmptyResultDataAccessException e) {
			member = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
			memberDao.insert(member);
		}

		return member.getId();

		/*		Member member = memberDao.selectByEmail(req.getEmail());
		
				if (member != null) {
					throw new DuplicateMemberException("dup email" + req.getEmail());
				}
		
				Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
				memberDao.insert(newMember);
				return newMember.getId();*/
	}

}
