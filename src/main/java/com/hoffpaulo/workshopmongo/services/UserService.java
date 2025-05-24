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
			return repository.findById(id).get();
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
	public User update(User obj) {
		User newObj = repository.findById(obj.getId()).get();
		updateData(newObj, obj);
		return repository.save(newObj);		
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	@Transactional
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
