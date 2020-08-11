package com.diogorolins.battleShip.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.diogorolins.battleShip.model.Game;
import com.diogorolins.battleShip.model.Player;
import com.diogorolins.battleShip.model.Ship;
import com.diogorolins.battleShip.model.ShipType;
import com.diogorolins.battleShip.repositories.GameRepository;
import com.diogorolins.battleShip.repositories.PlayerRepository;
import com.diogorolins.battleShip.repositories.ShipRepository;
import com.diogorolins.battleShip.repositories.ShipTypeRepository;


@Configuration
@Profile("dev")
public class Instantiation implements CommandLineRunner {

	@Autowired
	private ShipTypeRepository shipTyperepository;

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private ShipRepository shipRepository;

	@Autowired
	private BCryptPasswordEncoder pe;

	@Override
	public void run(String... args) throws Exception {

		ShipType shipType1 = new ShipType(null, "Porta-Aviões", 5);
		//ShipType shipType2 = new ShipType(null, "Porta-Aviões 2", 5);
		ShipType shipType3 = new ShipType(null, "Navio-Tanque", 4);
		//ShipType shipType4 = new ShipType(null, "Navio-Tanque 2", 4);
		ShipType shipType5 = new ShipType(null, "Contra-Torpedeiro", 3);
		//ShipType shipType6 = new ShipType(null, "Contra-Torpedeiro 2", 3);
		ShipType shipType7 = new ShipType(null, "Submarino", 2);
		//ShipType shipType8 = new ShipType(null, "Submarino 2", 2);

		//shipTyperepository.saveAll(
		//		Arrays.asList(shipType1, shipType2, shipType3, shipType4, shipType5, shipType6, shipType7, shipType8));

		shipTyperepository.saveAll(
					Arrays.asList(shipType1, shipType3, shipType5, shipType7));
		
				
		Player player1 = new Player(null, "Diogo", "diogo@email.com", pe.encode("123456"),null, true);
		Player player2 = new Player(null, "Bernardo", "be@email.com", pe.encode("123456"),null,  false);
		Player player3 = new Player(null, "Felipe", "fe@email.com", pe.encode("123456"),null, false);
		Player player4 = new Player(null, "Mariana", "ma@email.com", pe.encode("123456"),null,  false);

		playerRepository.saveAll(Arrays.asList(player1, player2, player3, player4));
		
		
		
	//	Game game = new Game(null, null, null, null, null);
	//	gameRepository.save(game);
	}
}
