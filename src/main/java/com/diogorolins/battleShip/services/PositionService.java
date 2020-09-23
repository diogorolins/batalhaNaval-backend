package com.diogorolins.battleShip.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogorolins.battleShip.model.Position;
import com.diogorolins.battleShip.model.Ship;
import com.diogorolins.battleShip.model.enu.StatusPosition;
import com.diogorolins.battleShip.repositories.PositionRepository;

@Service
public class PositionService {

	@Autowired
	private PositionRepository repository;
	

	public List<Position> getPositionsFromDto(List<String> positions, Ship ship) {
		List<Position> positionsConverted = new ArrayList<>();
		for(String positionDTO : positions) {
			Position position = new Position(null, positionDTO, ship, StatusPosition.CLEAN);
			insert(position);
			positionsConverted.add(position);
		}
		return positionsConverted;
	}
	
	public Position insert(Position position) {
		return repository.save(position);
	}
}