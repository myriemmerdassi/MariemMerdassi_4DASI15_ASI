package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;

import java.util.List;

public interface IEquipementService {
    List<Equipement> retrieveAllEquipements();
    Equipement addEquipement(Equipement c);
    Equipement updateEquipement(Equipement c);
    Equipement retrieveEquipement(Long idEquipement);
    void removeEquipement(Long idEquipement);
    List<Equipement> addEquipements (List<Equipement> list);
}
