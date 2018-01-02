package kijko.forum.domain.forms;

import org.springframework.stereotype.Component;

@Component
public class AnswerForm {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
