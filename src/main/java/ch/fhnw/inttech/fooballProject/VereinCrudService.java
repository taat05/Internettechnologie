package ch.fhnw.inttech.fooballProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.inttech.fooballProject.persistence.Verein;
import ch.fhnw.inttech.fooballProject.persistence.VereinRepository;

@RestController
public class VereinCrudService {
	
	
	@Autowired
	private VereinRepository vereinRepository;
	
	@GetMapping(path = "/api/verein/{id}", produces = "application/json")
	public Verein getP(@PathVariable int id) {
		return vereinRepository.findById(id).get();
	}
	
	@PutMapping(path = "/api/verein/{id}", produces = "application/json")
	public boolean updateVerein(@PathVariable int id, @RequestBody Verein verein) {
		Verein v = vereinRepository.findById(id).get();
		if (v == null)
			return false;
	
		v.setName(verein.getName());
		return true;
		
	}
			
	
	@PostMapping(path = "/api/verein/", produces = "application/json")
	public Verein createVerein(@RequestBody Verein verein) {
		Verein v = new Verein();

		v.setName(verein.getName());
		return v;
			
	}
}
