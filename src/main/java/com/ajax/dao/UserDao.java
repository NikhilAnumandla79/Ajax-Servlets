package com.ajax.dao;

import java.util.List;
import java.util.Set;

import com.ajax.model.Country;
import com.ajax.model.User;

public interface UserDao {
	public void insertUser(User user);

	public Set<Country> insertCountries(Set<Country> countries);
}
