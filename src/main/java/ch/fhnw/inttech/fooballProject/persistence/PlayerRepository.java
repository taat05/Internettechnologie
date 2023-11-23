package ch.fhnw.inttech.fooballProject.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
List<Player> findByLastName(String LastName);
List<Player> findByName(String Name);
}
