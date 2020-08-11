package com.diogorolins.battleShip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogorolins.battleShip.model.Position;
import com.diogorolins.battleShip.repositories.PositionRepository;

@Service
public class PositionService {

	@Autowired
	private PositionRepository repository;
	
	public List<Position> insert(List<Position> positions) {
		return repository.saveAll(positions);
	}
}