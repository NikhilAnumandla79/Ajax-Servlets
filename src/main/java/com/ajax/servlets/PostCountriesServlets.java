package com.ajax.servlets;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ajax.model.Country;
import com.ajax.service.UserService;
import com.ajax.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/postCountriesServlets")
public class PostCountriesServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserServiceImpl();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONParser jsonParser = new JSONParser();
		Set<Country> countries = new LinkedHashSet<>();
		try {
			JSONArray jsonArray = (JSONArray) jsonParser.parse(request.getParameter("data"));
			for(int i =0 ;i<jsonArray.size();i++) {
				JSONObject obj = (JSONObject) jsonArray.get(i);
				countries.add(new Country((String)obj.get("name"),(String)obj.get("capital"),(String)obj.get("region")));
			
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String data = gson.toJson(service.insertCounrtriesIntoDb(countries));
			System.out.println(data);
			response.setContentType("text/plain"); 
			response.getWriter().write(data);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
