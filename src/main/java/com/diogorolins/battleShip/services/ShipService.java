package com.diogorolins.battleShip.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogorolins.battleShip.model.Game;
import com.diogorolins.battleShip.model.Player;
import com.diogorolins.battleShip.model.Ship;
import com.diogorolins.battleShip.model.dto.ShipDTO;
import com.diogorolins.battleShip.repositories.ShipRepository;



@Service
public class ShipService {
	
	@Autowired
	private ShipRepository repository;
	
	@Autowired
	private ShipTypeService shipTypeService;
	
	@Autowired
	private PositionService positionService;

	public List<Ship> getShipsFromDTO(List<ShipDTO> ships, Player player, Game game) {
		List<Ship> shipsConverted = new ArrayList<>(); 
		for(ShipDTO shipDTO : ships) {
			Ship ship = new Ship();
			ship.setGame(game);
			ship.setShipType(shipTypeService.getbyId(shipDTO.getId()));
			ship.setPlayer(player);
			insert(ship);
			ship.setPositions(positionService.getPositionsFromDto(shipDTO.getPosition(),ship));
			insert(ship);
			shipsConverted.add(ship);
		}
		
		return shipsConverted;
	}
	
	
	public Ship insert(Ship ships) {
		
		return repository.save(ships);
	}

	

	

}
