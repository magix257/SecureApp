package com.telusko.secureapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
	//@PostAuthorize("hasRole('ADMIN')")
	//@Secured("ADMIN")
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
