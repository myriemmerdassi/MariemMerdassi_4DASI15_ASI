package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Contrat;

@Repository

public interface ContratRepository extends CrudRepository <Contrat, Long>{

}
