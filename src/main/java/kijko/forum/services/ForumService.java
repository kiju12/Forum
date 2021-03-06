package kijko.forum.services;

import java.util.ArrayList;

import kijko.forum.domain.Forum;

public interface ForumService {
	
	Forum findByTitle(String title);
	Forum findByThema(String themaTitle);
	ArrayList<Forum> findAll();
	void addForum(Forum forum);
	void deleteForum(Forum forum);
	boolean updateForum(Forum forum);
	
}
