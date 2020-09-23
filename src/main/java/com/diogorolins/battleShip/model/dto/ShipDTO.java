package com.diogorolins.battleShip.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.diogorolins.battleShip.model.Ship;

public class ShipDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private boolean destroyed;

	private List<String> position = new ArrayList<>();	
	
	public ShipDTO() {
		
	}
	
	public ShipDTO(Ship ship) {
		this.id = ship.getShipType().getId();
		this.destroyed = false;
		this.position = ship.getPositions().stream().map(s -> s.getPosition()).collect(Collectors.toList());
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer typeId) {
		this.id = typeId;
	}

	public List<String> getPosition() {
		return position;
	}

	public void setPosition(List<String> positions) {
		this.position = positions;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	

	
	

}