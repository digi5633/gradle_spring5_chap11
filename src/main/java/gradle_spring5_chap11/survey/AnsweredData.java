package gradle_spring5_chap11.survey;

import java.util.List;

public class AnsweredData {
	private List<String> responses;
	private Respondent res;

	public AnsweredData() {
		super();
	}

	public AnsweredData(List<String> responses, Respondent res) {
		this.responses = responses;
		this.res = res;
	}

	public AnsweredData(List<String> responses) {
		this.responses = responses;
	}

	public AnsweredData(Respondent res) {
		this.res = res;
	}

	public List<String> getResponses() {
		return responses;
	}

	public void setResponses(List<String> responses) {
		this.responses = responses;
	}

	public Respondent getRes() {
		return res;
	}

	public void setRes(Respondent res) {
		this.res = res;
	}

	@Override
	public String toString() {
		return "AnsweredData [responses=" + responses + ", res=" + res + "]";
	}

}
