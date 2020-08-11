package com.diogorolins.battleShip.model.dto;

import java.io.Serializable;

public class GameDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer player1;
	private Integer player2;

	public GameDTO() {

	}

	public Integer getPlayer1() {
		return player1;
	}

	public void setPlayer1(Integer player1) {
		this.player1 = player1;
	}

	public Integer getPlayer2() {
		return player2;
	}

	public void setPlayer2(Integer player2) {
		this.player2 = player2;
	}

	
}