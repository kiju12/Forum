package kijko.forum.domain;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Forum {

	private long id;
	private String title;
	private String dateOfCreate;
	private ArrayList<Thema> themas;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDateOfCreate() {
		return dateOfCreate;
	}
	public void setDateOfCreate(String dateOfCreate) {
		this.dateOfCreate = dateOfCreate;
	}
	public ArrayList<Thema> getThemas() {
		return themas;
	}
	public void setThemas(ArrayList<Thema> themas) {
		this.themas = themas;
	}
	
	
}
