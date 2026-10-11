package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Paiement;

@Repository

public interface PaiementRepository extends CrudRepository <Paiement, Long>{

}
