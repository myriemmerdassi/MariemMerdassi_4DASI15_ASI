package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    @Autowired

    final VehiculeRepository CR;

    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return (List<Vehicule>) CR.findAll();
    }

    @Override
    public Vehicule addVehicule(Vehicule c) {
        return CR.save(c);
    }

    @Override
    public Vehicule updateVehicule(Vehicule c) {
        return CR.save(c);
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return CR.findById(idVehicule).orElse(null);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        CR.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> addVehicules(List<Vehicule> list) {
        return (List<Vehicule>) CR.saveAll(list);
    }
}
