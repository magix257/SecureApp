package com.telusko.secureapp;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	@RequestMapping("login")
	public String login()
	{
		
		return "login.html";
	}
	@RequestMapping("failure")
	public String failure()
	{
		
		return "failure.jsp";
	}
}
