package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Employe;

@Repository

public interface EmployeRepository extends CrudRepository <Employe, Long>{

}
