package com.example.demo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@RequestMapping(value = "/")
	public String index() {
		return "redirect:/logon";
	}
	
	@RequestMapping(value = "")
	public String home() {
		return "redirect:/logon";
	}
	
	@RequestMapping(value = "/logon")
	public String logon(ModelMap map, HttpServletRequest req, HttpServletResponse res) {
		//Recuperation du username == email
		String user = req.getRemoteUser();
		System.out.println("Le username est" +user);
		if(user !=null)	
			return "index";
		else
			return "redirect:/login";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest  request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
	@RequestMapping(value = "/Admin/403")
	public String denied() {
		return "403";
	}
}
