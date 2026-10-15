package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.IReservationRepository;

@Service
public class ReservationServiceImpl extends GenericServiceImpl<Reservation, Long> implements IReservationService {

    public ReservationServiceImpl(IReservationRepository reservationRepository) {
        super(reservationRepository);
    }

    @Override
    protected String getEntityName() {
        return "Reservation";
    }

    @Override
    protected Long getId(Reservation entity) {
        return entity.getIdReservation();
    }

    @Override
    protected void setFields(Reservation existing, Reservation entity) {
        existing.setDateDebut(entity.getDateDebut());
        existing.setDateFin(entity.getDateFin());
        existing.setStatut(entity.getStatut());
        existing.setVehicule(entity.getVehicule());
        existing.setClient(entity.getClient());
        existing.setContrat(entity.getContrat());
    }

    @Override
    public boolean check(Reservation reservation, boolean isNew) {
        return reservation != null && reservation.getDateDebut() != null;
    }
}
