package com.diogorolins.battleShip.model.dto;

import java.io.Serializable;

public class GameDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private  GamePlayerDTO player;
	

	public GameDTO() {
		
	}
	
	

	public GameDTO(String id, GamePlayerDTO player) {
		this.id = id;
		this.player = player;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GamePlayerDTO getPlayer() {
		return player;
	}

	public void setPlayer(GamePlayerDTO player) {
		this.player = player;
	}

	
}