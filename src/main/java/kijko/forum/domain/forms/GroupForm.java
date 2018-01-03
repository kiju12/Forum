package kijko.forum.domain.forms;

import org.springframework.stereotype.Component;

@Component
public class GroupForm {

	private String crewName;
	private String description;
	private String members;
	
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
