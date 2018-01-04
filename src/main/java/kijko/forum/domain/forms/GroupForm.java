package kijko.forum.domain.forms;

import java.util.Date;

import org.springframework.stereotype.Component;

import kijko.forum.domain.Group;

@Component
public class GroupForm {

	private String crewName;
	private String description;
	private String members;
	
	public Group createGroup() {
		Group group = new Group();
			group.setDateOfCreate(new Date());
			group.setGroupName(crewName);
			group.setDescription(description);
		//Dodanie czlonkow ze stringa
			
		return group;
	}
	
	@Override
	public String toString() {
		return "GroupForm [crewName=" + crewName + ", description=" + description + ", members=" + members + "]";
	}
	public String getCrewName() {
		return crewName;
	}
	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	
	
}
