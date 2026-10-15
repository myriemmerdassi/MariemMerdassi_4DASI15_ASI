package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Utils;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.IMaintenanceRepository;

@Service
public class MaintenanceServiceImpl extends GenericServiceImpl<Maintenance, Long> implements IMaintenanceService {

    public MaintenanceServiceImpl(IMaintenanceRepository maintenanceRepository) {
        super(maintenanceRepository);
    }

    @Override
    protected String getEntityName() {
        return "Maintenance";
    }

    @Override
    protected Long getId(Maintenance entity) {
        return entity.getIdMaintenance();
    }

    @Override
    protected void setFields(Maintenance existing, Maintenance entity) {
        existing.setDateDebut(entity.getDateDebut());
        existing.setDateFin(entity.getDateFin());
        existing.setDescription(entity.getDescription());
        existing.setVehicule(entity.getVehicule());
    }

    @Override
    public boolean check(Maintenance maintenance, boolean isNew) {
        return maintenance != null && Utils.isNotEmpty(maintenance.getDescription());
    }
}
