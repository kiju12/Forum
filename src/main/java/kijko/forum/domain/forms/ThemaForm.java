package kijko.forum.domain.forms;

import org.springframework.stereotype.Component;

@Component
public class ThemaForm {

	private String title;
	private String firstPostContent;
	
	
	
	@Override
	public String toString() {
		return "ThemaForm [title=" + title + ", firstPostContent=" + firstPostContent + "]";
	}
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
