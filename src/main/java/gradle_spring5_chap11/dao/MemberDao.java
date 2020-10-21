package gradle_spring5_chap11.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import gradle_spring5_chap11.dto.Member;

@Component
public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* 결과가 1개 인 경우 */
	public Member selectByEmail(String email) {
		String sql = "SELECT ID, EMAIL, PASSWORD, NAME, REGDATE FROM MEMBER WHERE EMAIL = ?";
		return jdbcTemplate.queryForObject(sql, new MemberRowMapper(), email);
	}

	public void insert(Member member) {
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into member(email, password, name, regdate) values(?, ?, ?, ?)", new String[] { "id" });
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				return pstmt;
			}

		};
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(psc, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}

	public void update(Member member) {
		jdbcTemplate.update("update member set name=?, password=? where email=?", member.getName(),
				member.getPassword(), member.getEmail());
	}

	/* 결과가 1개 이상인 경우 */
	public List<Member> selectAll() {
		return jdbcTemplate.query("SELECT ID, EMAIL, PASSWORD, NAME, REGDATE FROM MEMBER", new MemberRowMapper());
	}

	/* 결과가 1개 인 경우 */
	public int count() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", Integer.class);
	}

	public void delete(Member member) {
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("delete from member where email = ?");
				pstmt.setString(1, member.getEmail());
				return pstmt;
			}

		};
		jdbcTemplate.update(psc);

	}

}
