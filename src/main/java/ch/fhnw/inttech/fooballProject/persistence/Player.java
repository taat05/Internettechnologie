package ch.fhnw.inttech.fooballProject.persistence;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Player {
	
	@Id
	@GeneratedValue
	public Integer id;
	public String name;
	public String lastName;
	public String position;
	public String teamName;
	public boolean deleted;
	
	
	public Integer getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}
	public String getName() {
		return name;
	}
	public String getPosition() {
		return position;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



}
