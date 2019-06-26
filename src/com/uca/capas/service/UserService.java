package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import com.uca.capas.domain.User;

public interface UserService {

	public void delete(User user);
	public void save(User user);
	public User findOne(Integer code);
	public boolean findOneUser(String username, String password) throws DataAccessException;
}
