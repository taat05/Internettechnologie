package ch.fhnw.inttech.fooballProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.inttech.fooballProject.business.PlayerVerification;
import ch.fhnw.inttech.fooballProject.persistence.Player;
import ch.fhnw.inttech.fooballProject.persistence.PlayerRepository;

@RestController
public class PlayerCrudService {
	
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private PlayerVerification playerVerification;
	
	@GetMapping(path = "/api/player/{id}", produces = "application/json")
	public Player getP(@PathVariable int id) {
		return playerRepository.findById(id).get();
	}
	
	@DeleteMapping(path = "/api/player/{id}", produces = "application/json")
	public boolean deletePlayer(@PathVariable int id) {
		Player p = playerRepository.findById(id).get();
		if (p == null)
			return false;
		p.setDeleted(true);
		playerRepository.save(p);
		return true;
	}
	
	@PutMapping(path = "/api/player/{id}", produces = "application/json")
	public boolean updatePlayer(@PathVariable int id, @RequestBody Player player) {
		Player p = playerRepository.findById(id).get();
		if (p == null)
			return false;

		p.setName(player.getName());
		p.setLastName(player.getLastName());
		p.setPosition(player.getPosition());
		p.setTeamName(player.getTeamName());
		
		if(playerVerification.validatePlayer(p)) {
			playerRepository.save(p);
		return true;
		} else {
			return false;
		}
	}
			
	
	@PostMapping(path = "/api/player/", produces = "application/json")
	public Player createPlayer(@RequestBody Player player) {
		Player p = new Player();

		p.setName(player.getName());
		p.setLastName(player.getLastName());
		p.setPosition(player.getPosition());
		p.setTeamName(player.getTeamName());
		p.setDeleted(false);
		if(playerVerification.validatePlayer(p)) {
			playerRepository.save(p);
			return p;
		} else {
			return null;
		}	
	}
}
