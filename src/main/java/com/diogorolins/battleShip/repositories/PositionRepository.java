package com.diogorolins.battleShip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogorolins.battleShip.model.Position;

public interface PositionRepository extends JpaRepository<Position, Integer>{

	
}