package kijko.forum.domain.forms;

import org.springframework.stereotype.Component;

@Component
public class AnswerForm {

	private String content;

	
	@Override
	public String toString() {
		return "AnswerForm [content=" + content + "]";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
