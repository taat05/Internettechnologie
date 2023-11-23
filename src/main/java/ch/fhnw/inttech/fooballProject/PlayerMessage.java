package ch.fhnw.inttech.fooballProject;

import ch.fhnw.inttech.fooballProject.persistence.Player;

public class PlayerMessage {
	
	public Integer id;
	public String name;
	public String lastName;
	public String position;
	public String teamName;
	

	public PlayerMessage() {
	}

	public PlayerMessage(Player p) {
		id = p.getId();
		name = p.getName();
		lastName = p.getLastName();
		position = p.getPosition();
		teamName = p.getTeamName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
