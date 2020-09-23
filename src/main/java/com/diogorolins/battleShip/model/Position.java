package com.diogorolins.battleShip.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.diogorolins.battleShip.model.enu.StatusPosition;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String position;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ship_id")	
	private Ship ship;
	
	private StatusPosition status;

	public Position() {
		
	}

	public Position(Integer id, String position, Ship ship, StatusPosition status) {
		super();
		this.id = id;
		this.position = position;
		this.ship = ship;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
		

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public StatusPosition getStatus() {
		return status;
	}

	public void setStatus(StatusPosition status) {
		this.status = status;
	}
	
	
	
}
