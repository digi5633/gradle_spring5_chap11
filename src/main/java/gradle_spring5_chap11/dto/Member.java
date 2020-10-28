package gradle_spring5_chap11.dto;

import java.time.LocalDateTime;

import gradle_spring5_chap11.exception.WrongIdPasswordException;

// @JsonIgnoreProperties({ "password" })
public class Member {
	private Long id;
	private String email;
	// @JsonIgnore
	private String password;
	private String name;
	// @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	// @JsonFormat(shape = Shape.STRING) // ISO-8601 형식으로 변환
	private LocalDateTime registerDateTime;

	public Member() {
		super();
	}

	public Member(String email, String password, String name, LocalDateTime registerDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}

	public Member(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", registerDateTime=" + registerDateTime + "]";
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

}
