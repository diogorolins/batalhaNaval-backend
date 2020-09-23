package com.diogorolins.battleShip.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Game implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date startDate;
	
	@ManyToMany
	private List<Player> players = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "winner")
	private Player winner;
	
	@OneToMany(mappedBy = "game")
	private List<Ship> ships = new ArrayList<>();
	
	
	public Game() {
		
	}


	public Game(String id, Date startDate, List<Player> players, Player winner, List<Ship> ships) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.players = players;
		this.winner = winner;
		this.ships = ships;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public Player getWinner() {
		return winner;
	}


	public void setWinner(Player winner) {
		this.winner = winner;
	}


	public List<Ship> getShips() {
		return ships;
	}


	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
