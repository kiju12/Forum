package kijko.forum.domain.forms;

import org.springframework.stereotype.Component;

@Component
public class ThemaForm {

	private String title;
	private String firstPostContent;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstPostContent() {
		return firstPostContent;
	}
	public void setFirstPostContent(String firstPostContent) {
		this.firstPostContent = firstPostContent;
	}
	
	
	
	
}
