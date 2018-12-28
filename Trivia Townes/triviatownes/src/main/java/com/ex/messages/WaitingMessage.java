package com.ex.messages;

import java.util.ArrayList;

import com.ex.game.PlayerBean;

public class WaitingMessage {
	
	ArrayList<PlayerBean> players;
	int status = 0;
	public synchronized ArrayList<PlayerBean> getPlayers() {
		return players;
	}
	public synchronized void setPlayers(ArrayList<PlayerBean> players) {
		this.players = players;
	}
	public synchronized int getStatus() {
		return status;
	}
	public synchronized void setStatus(int status) {
		this.status = status;
	}

}
