package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {

    @Autowired

    final ContratRepository CR;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return (List<Contrat>) CR.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return CR.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return CR.save(c);
    }

    @Override
    public Contrat retrieveContrat(Long idContrat) {
        return CR.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Long idContrat) {
        CR.deleteById(idContrat);
    }

    @Override
    public List<Contrat> addContrats(List<Contrat> list) {
        return (List<Contrat>) CR.saveAll(list);
    }
}
