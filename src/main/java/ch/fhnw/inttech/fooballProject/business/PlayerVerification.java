package ch.fhnw.inttech.fooballProject.business;

import org.springframework.stereotype.Service;

import ch.fhnw.inttech.fooballProject.persistence.Player;

@Service
public class PlayerVerification {
	
	public boolean validatePlayer(Player p) {
		if(p.getName().isEmpty() && p.getLastName().isEmpty())
		return false;
		else
		return true;
	}

}
