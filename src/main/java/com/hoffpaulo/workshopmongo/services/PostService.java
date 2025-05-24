package com.hoffpaulo.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoffpaulo.workshopmongo.domain.Post;
import com.hoffpaulo.workshopmongo.repositories.PostRepository;
import com.hoffpaulo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	@Transactional
	public Post findById(String id) {
		try {
			return repository.findById(id).get();
		}
		catch(NoSuchElementException e) {
			throw new ObjectNotFoundException("Object not found");
		}
	}
	
	@Transactional
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
	
}
