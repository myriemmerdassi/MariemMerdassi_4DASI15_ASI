package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    @Autowired

    final ReservationRepository CR;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return (List<Reservation>) CR.findAll();
    }

    @Override
    public Reservation addReservation(Reservation c) {
        return CR.save(c);
    }

    @Override
    public Reservation updateReservation(Reservation c) {
        return CR.save(c);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return CR.findById(idReservation).orElse(null);
    }

    @Override
    public void removeReservation(Long idReservation) {
        CR.deleteById(idReservation);
    }

    @Override
    public List<Reservation> addReservations(List<Reservation> list) {
        return (List<Reservation>) CR.saveAll(list);
    }
}
