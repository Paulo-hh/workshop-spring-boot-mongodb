package com.hoffpaulo.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoffpaulo.workshopmongo.domain.User;
import com.hoffpaulo.workshopmongo.dto.UserDTO;
import com.hoffpaulo.workshopmongo.repositories.UserRepository;
import com.hoffpaulo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional
	public List<User> findAll(){
		return repository.findAll();
	}
	
	@Transactional
	public User findById(String id) {
		try {
			User user = repository.findById(id).get();
			return user;
		}
		catch(NoSuchElementException e) {
			throw new ObjectNotFoundException("Object not found");
		}
	}
	
	@Transactional
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	@Transactional
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	@Transactional
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
