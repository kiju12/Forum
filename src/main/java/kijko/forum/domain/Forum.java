package kijko.forum.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Forum implements Comparable<Forum> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="created")
	private Date dateOfCreate;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="forum_id")
	private List<Thema> themas;
	
	public Forum() {
		themas = new ArrayList<Thema>();
	}
	
	public boolean hasThema(String themaTitle) {
		for(Thema thema : themas) {
			if(thema.getTitle().equals(themaTitle)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Thema getOneThema(String themaTitle) {
		Thema lookedFor = null;
		
		for(Thema thema : themas) {
			if(thema.getTitle().equals(themaTitle)) {
				lookedFor = thema;
			}
		}
		
		if(lookedFor != null) {
			return lookedFor;
		} else return null;
	}
	
	public Date getDateOfCreate() {
		return dateOfCreate;
	}
	public void setDateOfCreate(Date dateOfCreate) {
		this.dateOfCreate = dateOfCreate;
	}
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

	public List<Thema> getThemas() {
		return themas;
	}

	public void setThemas(List<Thema> themas) {
		this.themas = themas;
	}

	@Override
	public int compareTo(Forum forum) {
		if(this.getDateOfCreate().before(forum.getDateOfCreate())) {
			return -1;
		} else if(this.getDateOfCreate().after(forum.getDateOfCreate())) {
			return 1;
		}
		
		return 0;
	}

	
	
	
}
