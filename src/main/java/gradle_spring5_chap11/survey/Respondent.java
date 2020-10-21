package gradle_spring5_chap11.survey;

public class Respondent {
	private int age;
	private String location;

	public Respondent() {
		super();
	}

	public Respondent(int age, String location) {
		this.age = age;
		this.location = location;
	}

	public Respondent(int age) {
		this.age = age;
	}

	public Respondent(String location) {
		this.location = location;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Respondent [age=" + age + ", location=" + location + "]";
	}

}
