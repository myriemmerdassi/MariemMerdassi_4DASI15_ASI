package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    List<Maintenance> retrieveAllMaintenances();
    Maintenance addMaintenance(Maintenance c);
    Maintenance updateMaintenance(Maintenance c);
    Maintenance retrieveMaintenance(Long idMaintenance);
    void removeMaintenance(Long idMaintenance);
    List<Maintenance> addMaintenances (List<Maintenance> list);
}
