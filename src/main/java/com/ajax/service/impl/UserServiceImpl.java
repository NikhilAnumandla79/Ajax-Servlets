package com.ajax.service.impl;

import java.util.Set;

import com.ajax.dao.UserDao;
import com.ajax.dao.impl.UserDaoImpl;
import com.ajax.model.Country;
import com.ajax.model.User;
import com.ajax.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	@Override
	public void insertUserIntoDb(User user) {
		userDao.insertUser(user);
	}
	@Override
	public Set<Country> insertCounrtriesIntoDb(Set<Country> countries) {
		return userDao.insertCountries(countries);
		
	}

}
