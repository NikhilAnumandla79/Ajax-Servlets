package com.ajax.service;

import java.util.Set;

import com.ajax.model.Country;
import com.ajax.model.User;

public interface UserService {
	public void insertUserIntoDb(User user);

	public Set<Country> insertCounrtriesIntoDb(Set<Country> countries);
}
