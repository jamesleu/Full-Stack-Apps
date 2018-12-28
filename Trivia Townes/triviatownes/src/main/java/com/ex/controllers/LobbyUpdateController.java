package com.ex.controllers;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex.messages.GameInfoMessage;
import com.ex.services.GameManagerService;
import com.google.gson.Gson;

@RestController
@RequestMapping(value="/lobby-data")
@CrossOrigin(origins = "*")
public class LobbyUpdateController {
	
	private static Logger logger = Logger.getLogger(LobbyUpdateController.class);
	
	@RequestMapping(value="/{category}/data",
					method=RequestMethod.GET)
	@CrossOrigin(origins = "*")
	@ResponseBody
	public String sendLobbyData(@PathVariable String category) {
		
		category = category.toLowerCase();
		
		logger.trace(category);
		
		logger.trace("Sending Payload");
		
		GameManagerService gm = GameManagerService.getInstance();
		
		logger.trace(gm.gameList.size());
		
		ArrayList<GameInfoMessage> payload = gm.getGameSessionsInfo(category.toLowerCase());
		
		logger.trace("Hello");
		
		logger.trace("Testing");
		
		String json = new Gson().toJson(payload).toString();
		
		String fJson = "{\"data\":" + json + "}";
		
		logger.trace(fJson);
		
		return fJson;
	}
}