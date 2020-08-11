package com.diogorolins.battleShip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogorolins.battleShip.model.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{

}
