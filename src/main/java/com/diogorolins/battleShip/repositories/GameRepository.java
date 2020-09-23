package com.diogorolins.battleShip.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogorolins.battleShip.model.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{

	
	public Optional<Game> findById(String id);
	
}
