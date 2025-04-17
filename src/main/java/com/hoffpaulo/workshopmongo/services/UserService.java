package com.hoffpaulo.workshopmongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoffpaulo.workshopmongo.dto.UserDTO;
import com.hoffpaulo.workshopmongo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<UserDTO> findAll(){
		return repository.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
}
