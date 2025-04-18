package com.hoffpaulo.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoffpaulo.workshopmongo.domain.User;
import com.hoffpaulo.workshopmongo.repositories.UserRepository;
import com.hoffpaulo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		try {
			User user = repository.findById(id).get();
			return user;
		}
		catch(NoSuchElementException e) {
			throw new ObjectNotFoundException("Object not found");
		}
	}
}
