package com.diogorolins.battleShip.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogorolins.battleShip.model.Game;
import com.diogorolins.battleShip.model.Player;
import com.diogorolins.battleShip.model.Ship;
import com.diogorolins.battleShip.model.ShipType;
import com.diogorolins.battleShip.model.dto.ShipDTO;
import com.diogorolins.battleShip.repositories.ShipRepository;

@Service
public class ShipService {

	@Autowired
	private ShipRepository repository;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private ShipTypeService typeService;

	public Ship insert(Ship ship) {
		return repository.save(ship);
	}

	public Ship convertFromDTO(ShipDTO dto, Game game) {

		Ship ship = new Ship();
		Player player = playerService.findById(dto.getPlayer());
		ShipType type = typeService.getbyId(dto.getType());
		ship.setPlayer(player);
		ship.setPositions(dto.getPositions());
		ship.setShipType(type);
		ship.setGame(game);
		return ship;
	}

}
