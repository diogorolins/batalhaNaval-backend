package com.diogorolins.battleShip.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.diogorolins.battleShip.model.Position;

public class ShipDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer type;
	private Integer player;
	private List<Position> positions = new ArrayList<>();	
	
	public ShipDTO() {
		
	}


	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPlayer() {
		return player;
	}

	public void setPlayer(Integer player) {
		this.player = player;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPosition(List<Position> positions) {
		this.positions = positions;
	}
	
	

}