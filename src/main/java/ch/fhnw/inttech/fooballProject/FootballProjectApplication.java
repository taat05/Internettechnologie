package ch.fhnw.inttech.fooballProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ch.fhnw.inttech.fooballProject.persistence.Player;
import ch.fhnw.inttech.fooballProject.persistence.PlayerRepository;
import jakarta.annotation.PostConstruct;


@SpringBootApplication
public class FootballProjectApplication {
	
	@Autowired
	private PlayerRepository playerRepository;

	public static void main(String[] args) {
		SpringApplication.run(FootballProjectApplication.class, args);
	}

	@PostConstruct
	public void createPlayerData() {
		Player p = new Player ();
		p.setId(1);
		p.setName("Lionel");
		p.setLastName("Messi");
		p.setPosition("Rechtsflügel");
		p.setTeamName("Paris Saint-Germain");
		
		playerRepository.save(p);
	}
}
