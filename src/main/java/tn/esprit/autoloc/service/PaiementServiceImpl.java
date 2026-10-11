package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    @Autowired

    final PaiementRepository CR;

    @Override
    public List<Paiement> retrieveAllPaiements() {
        return (List<Paiement>) CR.findAll();
    }

    @Override
    public Paiement addPaiement(Paiement c) {
        return CR.save(c);
    }

    @Override
    public Paiement updatePaiement(Paiement c) {
        return CR.save(c);
    }

    @Override
    public Paiement retrievePaiement(Long idPaiement) {
        return CR.findById(idPaiement).orElse(null);
    }

    @Override
    public void removePaiement(Long idPaiement) {
        CR.deleteById(idPaiement);
    }

    @Override
    public List<Paiement> addPaiements(List<Paiement> list) {
        return (List<Paiement>) CR.saveAll(list);
    }
}
