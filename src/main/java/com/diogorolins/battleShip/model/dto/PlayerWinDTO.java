package com.diogorolins.battleShip.model.dto;

import java.io.Serializable;

public class PlayerWinDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer playerId;
	
	public PlayerWinDTO() {
		
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	
	
	
}
