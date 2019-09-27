package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDAO;
import com.entity.User;

@Controller
public class RegisterLogin {
	@Autowired
	UserDAO userDAO;
@GetMapping("/register")
	public String getRegister() {
		return "register";
	}
@PostMapping("register")
public String register(@RequestParam("name")String name, @RequestParam("address")String address,@RequestParam("sex")String sex, @RequestParam("username")String username, @RequestParam("password") String password, HttpSession session, ModelAndView model) {
	
	User user=userDAO.registerUser(name, sex, address, username, password);
	if(user == null) {
		return "redirect:"+"/register";
	}
	
	return "redirect:"+"/login";
	
}
}
