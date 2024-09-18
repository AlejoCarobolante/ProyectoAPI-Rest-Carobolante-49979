package repositories;

import entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PersonaRepositoriy extends JpaRepository<Persona, Long> {

}
