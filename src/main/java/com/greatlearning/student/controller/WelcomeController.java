package com.greatlearning.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	@RequestMapping("/")
	public String showWelcome() {
		return "welcome";	//  prefix is /WEB-INF/views/ , suffix is .jsp
	}
}
