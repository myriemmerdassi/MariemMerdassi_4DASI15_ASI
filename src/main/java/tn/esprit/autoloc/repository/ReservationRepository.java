package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Reservation;

@Repository

public interface ReservationRepository extends CrudRepository <Reservation, Long>{

}
