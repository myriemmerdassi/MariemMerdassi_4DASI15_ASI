package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    @Autowired

    final EquipementRepository CR;

    @Override
    public List<Equipement> retrieveAllEquipements() {
        return (List<Equipement>) CR.findAll();
    }

    @Override
    public Equipement addEquipement(Equipement c) {
        return CR.save(c);
    }

    @Override
    public Equipement updateEquipement(Equipement c) {
        return CR.save(c);
    }

    @Override
    public Equipement retrieveEquipement(Long idEquipement) {
        return CR.findById(idEquipement).orElse(null);
    }

    @Override
    public void removeEquipement(Long idEquipement) {
        CR.deleteById(idEquipement);
    }

    @Override
    public List<Equipement> addEquipements(List<Equipement> list) {
        return (List<Equipement>) CR.saveAll(list);
    }
}
