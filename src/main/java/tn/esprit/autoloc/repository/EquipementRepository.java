package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Equipement;

@Repository

public interface EquipementRepository extends CrudRepository <Equipement, Long>{

}
