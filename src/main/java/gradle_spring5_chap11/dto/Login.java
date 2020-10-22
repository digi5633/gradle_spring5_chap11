package gradle_spring5_chap11.dto;

public class Login {

	private String loginType;
	private String jobCode;
	private String tool;
	private String favoriteOs;
	private String likeOs;

	public String getLikeOs() {
		return likeOs;
	}

	public void setLikeOs(String likeOs) {
		this.likeOs = likeOs;
	}

	public String getFavoriteOs() {
		return favoriteOs;
	}

	public void setFavoriteOs(String favoriteOs) {
		this.favoriteOs = favoriteOs;
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

}
