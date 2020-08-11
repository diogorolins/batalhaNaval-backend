package com.diogorolins.battleShip.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogorolins.battleShip.exception.ObjectNotFoundException;
import com.diogorolins.battleShip.model.Game;
import com.diogorolins.battleShip.model.Player;
import com.diogorolins.battleShip.model.Position;
import com.diogorolins.battleShip.model.Ship;
import com.diogorolins.battleShip.model.dto.GameDTO;
import com.diogorolins.battleShip.model.dto.ShipDTO;
import com.diogorolins.battleShip.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private ShipService shipService;
	
	@Autowired 
	private PositionService positionService;

	public List<Game> findAll() {
		return repository.findAll();
	}

	public Game findById(Integer id) {
		Optional<Game>  obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Resource not found"));
	}

	public Game convertFromDTO(GameDTO objDto) {

		List<Player> players = new ArrayList<>();
		Player player1 = playerService.findById(objDto.getPlayer1());
		Player player2 = playerService.findById(objDto.getPlayer2());
		players.addAll(Arrays.asList(player1, player2));

		return new Game(null, new Date(), players, null, null);
	}

	public Game createGame(Game game) {

		return repository.save(game);
	}

	public Game insertShips(List<ShipDTO> shipsDTO, Integer id) {
		Game game = findById(id);
		for (ShipDTO dto : shipsDTO) {
			Ship ship = shipService.convertFromDTO(dto, game);
			List<Position> positions = positionService.insert(dto.getPositions());
			ship.setPositions(positions);
			for(Position position : ship.getPositions()) {
				position.setShip(ship);
			}
			shipService.insert(ship);
			game.getShips().add(ship);
		}

		return repository.save(game);
	}

}
