package gradle_spring5_chap11.survey;

import java.util.Collections;
import java.util.List;

public class Question {
	// 질문 제목
	private String title;

	// 답변보기 옵션
	private List<String> options;

	public Question() {
		super();
	}

	public Question(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	// @param title 질문제목
	public Question(String title) {
		this(title, Collections.<String>emptyList());
	}

	public Question(List<String> options) {
		this.options = options;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// @param options 답변보기
	public List<String> getOptions() {
		return options;
	}

	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Question [title=" + title + ", options=" + options + "]";
	}

}
