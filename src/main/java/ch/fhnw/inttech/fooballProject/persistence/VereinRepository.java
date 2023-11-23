package ch.fhnw.inttech.fooballProject.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VereinRepository extends JpaRepository<Verein, Integer> {
List<Player> findByName(String Name);
}
