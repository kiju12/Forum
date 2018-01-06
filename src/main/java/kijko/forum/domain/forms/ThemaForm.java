package kijko.forum.domain.forms;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import kijko.forum.domain.Post;
import kijko.forum.domain.Thema;
import kijko.forum.services.UserService;

@Component
public class ThemaForm {

	private String title;
	private String firstPostContent;
	
	@Autowired
	private UserService userService;
	
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
