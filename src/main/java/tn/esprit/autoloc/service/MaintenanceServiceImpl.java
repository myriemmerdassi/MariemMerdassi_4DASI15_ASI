package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.IMaintenanceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    @Autowired

    final IMaintenanceRepository CR;

    @Override
    public List<Maintenance> retrieveAllMaintenances() {
        return CR.findAll();
    }

    @Override
    public Maintenance addMaintenance(Maintenance c) {
        return CR.save(c);
    }

    @Override
    public Maintenance updateMaintenance(Maintenance c) {
        return CR.save(c);
    }

    @Override
    public Maintenance retrieveMaintenance(Long idMaintenance) {
        return CR.findById(idMaintenance).orElse(null);
    }

    @Override
    public void removeMaintenance(Long idMaintenance) {
        CR.deleteById(idMaintenance);
    }

    @Override
    public List<Maintenance> addMaintenances(List<Maintenance> list) {
        return (List<Maintenance>) CR.saveAll(list);
    }
}
