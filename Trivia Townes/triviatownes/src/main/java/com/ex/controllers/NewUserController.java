package com.ex.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/new-user")
@CrossOrigin(origins = "*")
public class NewUserController {
	
	private static Logger logger = Logger.getLogger(NewUserController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@CrossOrigin(origins = "*")
	public HttpServletResponse newUser(HttpServletResponse resp, HttpServletRequest req) {
		
		//No matter what create a new session
		HttpSession session = req.getSession(false);
		if (session == null) {
			logger.trace("Creating New Game Session");
		    session = req.getSession(true);
		} else {
			logger.trace("Deleting old game session and creating new one");
			session.invalidate();
			session = req.getSession(true);
			
		}
		return null;
	}
	

}
