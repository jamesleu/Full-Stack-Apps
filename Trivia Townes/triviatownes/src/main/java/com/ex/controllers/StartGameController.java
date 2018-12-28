package com.ex.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.game.GameSessionBean;
import com.ex.services.GameManagerService;

@Controller
@RequestMapping("/start-game")
@CrossOrigin(origins = "*")
public class StartGameController {
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@CrossOrigin(origins = "*")
	public int startGame(HttpServletRequest req, HttpServletResponse resp) {
		
		StringBuffer gameKey = new StringBuffer(req.getParameter("key"));
		
		GameManagerService manager = GameManagerService.getInstance();
		
		GameSessionBean game = manager.getGameByKey(gameKey);
		
		//inits game
		game.startGame();
		
		return 0;
	}
}
