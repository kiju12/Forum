package kijko.forum.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kijko.forum.domain.Forum;
import kijko.forum.domain.repository.ForumRepository;
import kijko.forum.services.ForumService;

@Service
public class ForumServiceImpl implements ForumService {
	
	@Autowired
	private ForumRepository forumRepo;
	
	
	@Override
	public void addForum(Forum forum) {
		forumRepo.save(forum);
	}
	
	@Override
	public Forum findByTitle(String title) {
		return forumRepo.findByTitle(title);
	}

	@Override
	public Forum findByThema(String themaTitle) {
		ArrayList<Forum> allForums = (ArrayList<Forum>) forumRepo.findAll();
		Forum lookedFor = null;
		
		for(Forum f : allForums) {
			if(f.hasThema(themaTitle)) {
				lookedFor = f;
			}
		}
		//Zwraca null, gdy nie znajdzie. Jeśli istnieje więcej niż jedno takie forum, zwraca pierwsze znalezione
		return lookedFor;
	}

	@Override
	public ArrayList<Forum> findAll() {
		return (ArrayList<Forum>) forumRepo.findAll();
	}

	@Override
	public void deleteForum(Forum forum) {
		forumRepo.delete(forum);
	}

	@Override
	public boolean updateForum(Forum forum) {
		boolean updated = false;
		
		for(Forum f : forumRepo.findAll()) {
			if(forum.getId() == f.getId()) {
				forumRepo.save(forum);
				updated = true;
				break;
			}
		}
		
		return updated;
			
	}


}
