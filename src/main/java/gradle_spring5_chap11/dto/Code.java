package gradle_spring5_chap11.dto;

public class Code {
	
	private String code;
	private String label;

	public Code(String code, String label) {
		this.code = code;
		this.label = label;
	}

	public String getCode() {
		return code;
	}

	public String getLabel() {
		return label;
	}
	
}
