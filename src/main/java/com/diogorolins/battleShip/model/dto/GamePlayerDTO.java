package com.diogorolins.battleShip.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GamePlayerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private List<ShipDTO> ships = new ArrayList<>();
	
	public GamePlayerDTO() {
		
	}
	
	public GamePlayerDTO(Integer id, List<ShipDTO> ships) {
		this.id = id;
		this.ships = ships;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ShipDTO> getShips() {
		return ships;
	}

	public void setShips(List<ShipDTO> ships) {
		this.ships = ships;
	}
	
	
	
}
