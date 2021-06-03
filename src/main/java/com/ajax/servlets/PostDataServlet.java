package com.ajax.servlets;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ajax.model.User;
import com.ajax.service.UserService;
import com.ajax.service.impl.UserServiceImpl;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/postDataServlet")
public class PostDataServlet extends HttpServlet{
	UserService service = new UserServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String data = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) parser.parse(data);
			String fullname  = (String)jsonObject.get("fullname");
			int age = Integer.parseInt(String.valueOf(jsonObject.get("age")));
			boolean married = (boolean) jsonObject.get("married");
			String gender = (String)jsonObject.get("gender");
			
			User user = new User(fullname, age, married, gender);
			service.insertUserIntoDb(user);
			
			System.out.println(fullname +" "+age);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
