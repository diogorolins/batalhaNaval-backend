package com.diogorolins.battleShip.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameCompleteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private List<GamePlayerDTO> players = new ArrayList<>();

	public GameCompleteDTO() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<GamePlayerDTO> getPlayers() {
		return players;
	}

	public void setPlayers(List<GamePlayerDTO> players) {
		this.players = players;
	}
	
	
	
}
