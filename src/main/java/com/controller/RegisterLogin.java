package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDAO;
@Controller
public class RegisterLogin {
	@Autowired
	private UserDAO UserDAO;
	@PostMapping("/do-register")
	public ModelAndView doregister(@RequestParam("name") String name,@RequestParam("sex") String sex,@RequestParam("address") String address, @RequestParam("username")String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
		UserDAO.registerUser(name, sex, address, username, password);
		
		  return new ModelAndView("welcome", "name", name);
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
}
