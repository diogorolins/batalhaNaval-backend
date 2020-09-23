package com.diogorolins.battleShip.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diogorolins.battleShip.model.Game;
import com.diogorolins.battleShip.model.Player;
import com.diogorolins.battleShip.model.dto.GameCompleteDTO;
import com.diogorolins.battleShip.model.dto.GameDTO;
import com.diogorolins.battleShip.model.dto.PlayerWinDTO;
import com.diogorolins.battleShip.services.GameService;
import com.diogorolins.battleShip.services.PlayerService;

@RestController
@RequestMapping(value = "/games")
public class GameResource {

	@Autowired
	private GameService service;
	
	@Autowired
	private PlayerService playerService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Game> insert(@RequestBody GameDTO objDto) {
		Game game;
		if (!service.gameAlreadyCreated(objDto)) {
			game = service.getGameFromDto(objDto);
			game = service.insert(game);
		} else {
			game = service.insertPlayer(objDto);
		}
		
		return ResponseEntity.ok(game);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<GameCompleteDTO> findById(@PathVariable String id) {
		Game game = service.getById(id).get();
		GameCompleteDTO gameDto = service.convertToDTO(game);
;		return ResponseEntity.ok(gameDto);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<GameCompleteDTO> update(@RequestBody PlayerWinDTO playerDto, @PathVariable String id) {
		Game game = service.getById(id).get();
		Player player = playerService.findById(playerDto.getPlayerId());
		game = service.insertWinner(game, player);
		GameCompleteDTO gameDto = service.convertToDTO(game);
		return ResponseEntity.ok(gameDto);
	}

	
	
}
