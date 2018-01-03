package kijko.forum.domain;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Group {

	private long id;
	private User leader;
	private String groupName;
	private String dateOfCreate;
	private String description;
	private ArrayList<User> members;
	
	
	public String getDateOfCreate() {
		return dateOfCreate;
	}
	public void setDateOfCreate(String dateOfCreate) {
		this.dateOfCreate = dateOfCreate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<User> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}
	
	
}
