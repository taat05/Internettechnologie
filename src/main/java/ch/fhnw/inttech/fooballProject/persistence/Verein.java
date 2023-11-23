package ch.fhnw.inttech.fooballProject.persistence;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Verein {
	
	@Id
	@GeneratedValue
	public Integer vid;
	public String name;
	
	public Integer getVid() {
		return vid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
