package com.diogorolins.battleShip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogorolins.battleShip.model.Ship;

public interface ShipRepository extends JpaRepository<Ship, Integer>{

}
