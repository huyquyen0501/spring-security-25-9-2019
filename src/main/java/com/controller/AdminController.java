package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDAO;
import com.entity.User;

@Controller(value = "/admin")
public class AdminController {
	@Autowired
	private UserDAO userdao;

	@RequestMapping
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();

		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/getall")
	public ModelAndView getAll() {
		ModelAndView model = new ModelAndView();
		ArrayList<User> list= userdao.getAll();
		model.addObject("list",list);
		model.setViewName("getall");
		return model;
		

	}
}
