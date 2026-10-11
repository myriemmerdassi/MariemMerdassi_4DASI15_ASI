package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    @Autowired

    final EmployeRepository CR;

    @Override
    public List<Employe> retrieveAllEmployes() {
        return (List<Employe>) CR.findAll();
    }

    @Override
    public Employe addEmploye(Employe c) {
        return CR.save(c);
    }

    @Override
    public Employe updateEmploye(Employe c) {
        return CR.save(c);
    }

    @Override
    public Employe retrieveEmploye(Long idEmploye) {
        return CR.findById(idEmploye).orElse(null);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        CR.deleteById(idEmploye);
    }

    @Override
    public List<Employe> addEmployes(List<Employe> list) {
        return (List<Employe>) CR.saveAll(list);
    }
}
