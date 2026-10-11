package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;

import java.util.List;

public interface IPaiementService {
    List<Paiement> retrieveAllPaiements();
    Paiement addPaiement(Paiement c);
    Paiement updatePaiement(Paiement c);
    Paiement retrievePaiement(Long idPaiement);
    void removePaiement(Long idPaiement);
    List<Paiement> addPaiements (List<Paiement> list);
}
