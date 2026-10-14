package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    @Autowired

    final IAgenceRepository CR;

    @Override
    public List<Agence> retrieveAllAgences() {
        return CR.findAll();
    }

    @Override
    public Agence addAgence(Agence c) {
        return CR.save(c);
    }

    @Override
    public Agence updateAgence(Agence c) {
        return CR.save(c);
    }

    @Override
    public Agence retrieveAgence(Long idAgence) {
        return CR.findById(idAgence).orElse(null);
    }

    @Override
    public void removeAgence(Long idAgence) {
        CR.deleteById(idAgence);
    }

    @Override
    public List<Agence> addAgences(List<Agence> list) {
        return (List<Agence>) CR.saveAll(list);
    }
}
