package kijko.forum.domain.forms;

import java.util.Date;

import org.springframework.stereotype.Component;

import kijko.forum.domain.Thema;

@Component
public class ThemaForm {

	private String title;
	private String firstPostContent;
	private String forumTitle;
	
	
	public String getForumTitle() {
		return forumTitle;
	}
	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}
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
	public Thema createThema() {
		Thema thema = new Thema();
			thema.setTitle(this.title);
			thema.setCreateDate(new Date());
		
			
		
		return thema;
	}
	
	
	
	
}
