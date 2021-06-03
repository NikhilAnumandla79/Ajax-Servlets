package com.ajax.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import com.ajax.dao.UserDao;
import com.ajax.model.Country;
import com.ajax.model.User;
import com.ajax.utility.DbConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public void insertUser(User user) {
		Connection con = DbConnection.getConnection();
		String query = "INSERT INTO users(user_fullname, user_age, user_ismarried, user_gender) VALUES(?,?,?,?)";

		try (PreparedStatement pstmt = con.prepareStatement(query);) {
			pstmt.setString(1, user.getFullname());
			pstmt.setInt(2, user.getAge());
			pstmt.setString(3, String.valueOf(user.isMarried()));
			pstmt.setString(4, user.getGender());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public Set<Country> insertCountries(Set<Country> countries) {
		Connection con = DbConnection.getConnection();
		String query = "INSERT INTO countries(name, capital, region ) VALUES(?,?,?)";
		try (PreparedStatement pstmt = con.prepareStatement(query);) {
			for (Country country : countries) {

				pstmt.setString(1, country.getName());
				pstmt.setString(2, country.getCapital());
				pstmt.setString(3, country.getRegion());
				pstmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return countries;

	}

}
