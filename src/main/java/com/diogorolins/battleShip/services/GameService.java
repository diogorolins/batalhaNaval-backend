package com.diogorolins.battleShip.services;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogorolins.battleShip.model.Game;
import com.diogorolins.battleShip.model.Player;
import com.diogorolins.battleShip.model.Ship;
import com.diogorolins.battleShip.model.dto.GameCompleteDTO;
import com.diogorolins.battleShip.model.dto.GameDTO;
import com.diogorolins.battleShip.model.dto.GamePlayerDTO;
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
	

	public boolean gameAlreadyCreated(GameDTO objDto) {		
		Optional<Game> gameExists = getById(objDto.getId());
		if(gameExists.isPresent()) {
			return true;
		} 
		return false;
	}

	public Optional<Game> getById(String id) {
		return repository.findById(id);
	}

	public Game getGameFromDto(GameDTO objDto) {
		
		Player player = playerService.findById(objDto.getPlayer().getId());
		Game game = createGame(objDto, player);
		insert(game);
		player.getGames().add(game);
		List<Ship> ships = shipService.getShipsFromDTO(objDto.getPlayer().getShips(), player, game);
		game.getShips().addAll(ships);
		return game;
	}
	
	public Game insert(Game game) {
		return repository.save(game);
	}

	
	private Game createGame(GameDTO objDto, Player player) {
		Game game = new Game();
		game.setId(objDto.getId());
		game.getPlayers().add(player);
		game.setStartDate(new Date());
		return game;
	}


	public Game insertPlayer(GameDTO objDto) {
		Player player = playerService.findById(objDto.getPlayer().getId());
		Game game = repository.findById(objDto.getId()).get();
		player.getGames().add(game);
		game.getPlayers().add(player);
		List<Ship> ships = shipService.getShipsFromDTO(objDto.getPlayer().getShips(), player, game);
		game.getShips().addAll(ships);
		return insert(game);
	}

	public GameCompleteDTO convertToDTO(Game game) {
		GameCompleteDTO gameDto = new GameCompleteDTO();
		gameDto.setId(game.getId());
		for(Player player : game.getPlayers()) {
			GamePlayerDTO playerDto = new GamePlayerDTO();
			playerDto.setId(player.getId());
			playerDto.setShips(game.getShips().stream()
					.filter(f -> f.getPlayer().getId() == player.getId())
					.map(s -> new ShipDTO(s)).collect(Collectors.toList()));
		gameDto.getPlayers().add(playerDto);
	}
		
			

		return gameDto;
	}

	public Game insertWinner(Game game, Player player) {
		game.setWinner(player);
		return insert(game);
	}


	

}
