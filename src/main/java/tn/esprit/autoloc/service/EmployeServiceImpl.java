package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Utils;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.IEmployeRepository;

@Service
public class EmployeServiceImpl extends GenericServiceImpl<Employe, Long> implements IEmployeService {

    public EmployeServiceImpl(IEmployeRepository employeRepository) {
        super(employeRepository);
    }

    @Override
    protected String getEntityName() {
        return "Employe";
    }

    @Override
    protected Long getId(Employe entity) {
        return entity.getIdEmploye();
    }

    @Override
    protected void setFields(Employe existing, Employe entity) {
        existing.setNom(entity.getNom());
        existing.setPrenom(entity.getPrenom());
        existing.setRole(entity.getRole());
        existing.setAgence(entity.getAgence());
    }

    @Override
    public boolean check(Employe employe, boolean isNew) {
        return employe != null
                && Utils.isNotEmpty(employe.getNom())
                && Utils.isNotEmpty(employe.getPrenom());
    }
}
