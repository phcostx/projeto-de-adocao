package projeto_adocao.projeto.de.adocao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto_adocao.projeto.de.adocao.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
