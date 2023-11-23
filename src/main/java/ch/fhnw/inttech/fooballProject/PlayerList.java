package ch.fhnw.inttech.fooballProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.inttech.fooballProject.persistence.Player;
import ch.fhnw.inttech.fooballProject.persistence.PlayerRepository;

@RestController
public class PlayerList {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping(path = "/api/players", produces = "application/json")
	public List<Player> getPlayers(@RequestParam(required = false) String filter){
		if (filter == null) {
		return playerRepository.findAll();
		}else {
			return playerRepository.findByLastName(filter);
		}
	}
}
