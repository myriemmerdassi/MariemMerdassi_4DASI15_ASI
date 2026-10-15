package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.IContratRepository;

@Service
public class ContratServiceImpl extends GenericServiceImpl<Contrat, Long> implements IContratService {

    public ContratServiceImpl(IContratRepository contratRepository) {
        super(contratRepository);
    }

    @Override
    protected String getEntityName() {
        return "Contrat";
    }

    @Override
    protected Long getId(Contrat entity) {
        return entity.getIdContrat();
    }

    @Override
    protected void setFields(Contrat existing, Contrat entity) {
        existing.setDateSignature(entity.getDateSignature());
        existing.setMontantTotal(entity.getMontantTotal());
        existing.setValide(entity.isValide());
    }

    @Override
    public boolean check(Contrat contrat, boolean isNew) {
        return contrat != null && contrat.getMontantTotal() != null;
    }
}
