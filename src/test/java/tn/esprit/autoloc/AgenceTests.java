package tn.esprit.autoloc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.IAgenceRepository;
import tn.esprit.autoloc.service.IAgenceService;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class AgenceTests {

    @Autowired
    private AgenceRepositoryMock basicAgenceRepository;

    @Autowired
    private IAgenceRepository fullAgenceRepository;

    @Autowired
    private IAgenceService agenceService;

    private void addAgence(CrudRepository<Agence, Long> repository) {
        int info = (int) System.currentTimeMillis();

        Agence agence = new Agence();
        agence.setNom("Agence ariana " + info);
        agence.setAdresse("1 Rue Hedi");
        agence.setTelephone("71585874");
        agence.setVille("Tunis");

        Vehicule v1 = new Vehicule();
        v1.setCategorie(CategorieVehicule.SUV);
        v1.setImmatriculation("TU96-" + info);
        v1.setMarque("Isuzu");
        v1.setModele("DMax");
        v1.setStatut(StatutVehicule.MAINTENANCE);
        v1.setTarifJournalier(new BigDecimal("100"));
        v1.setAgence(agence);

        Vehicule v2 = new Vehicule();
        v2.setCategorie(CategorieVehicule.UTILITAIRE);
        v2.setImmatriculation("TU95-" + info);
        v2.setMarque("Toyota");
        v2.setModele("Yaris");
        v2.setStatut(StatutVehicule.DISPONIBLE);
        v2.setTarifJournalier(new BigDecimal("80"));
        v2.setAgence(agence);

        agence.getVehicules().add(v2);
        agence.getVehicules().add(v1);

        repository.save(agence);
    }

    @Test
    public void basicAddAgence() {
        addAgence(basicAgenceRepository);
    }

    @Test
    public void fullAddAgence() {
        addAgence(fullAgenceRepository);
    }

    private void loadAgence(CrudRepository<Agence, Long> repository, String repoType) {
        StringBuilder sb = new StringBuilder("\nType de depot: " + repoType + "\n");
        for (Agence agence : repository.findAll()) {
            sb.append(agence.getIdAgence()).append(" | ").append(agence.getNom()).append("\n");
            sb.append("Vehicules Count : ").append(agence.getVehicules().size()).append("\n");
            for (Vehicule v : agence.getVehicules()) {
                sb.append("=== ").append(v.getIdVehicule()).append("|").append(v.getImmatriculation()).append("\n");
            }
        }
        System.out.println(sb);
    }

    @Test
    public void basicLoadAgence() {
        loadAgence(basicAgenceRepository, "CrudRepository (basic)");
    }

    @Test
    public void fullLoadAgence() {
        loadAgence(fullAgenceRepository, "JpaRepository (full)");
    }

    @Test
    public void loadSortedAgences() {
        Sort sort = Sort.by("idAgence").descending();
        List<Agence> agences = fullAgenceRepository.findAll(sort);
        for (Agence agence : agences) {
            System.out.println(agence.getIdAgence() + " | " + agence.getNom() + " | " + agence.getVille() + " | " + agence.getAdresse());
        }
    }

    @Test
    public void loadPagedAgences() {
        Sort sort = Sort.by("idAgence").descending();
        Pageable pageable = PageRequest.of(0, 2, sort);
        Page<Agence> page = fullAgenceRepository.findAll(pageable);

        System.out.println("Total pages: " + page.getTotalPages());
        System.out.println("Current page: " + page.getNumber());
        for (Agence agence : page.getContent()) {
            System.out.println(agence.getIdAgence() + " | " + agence.getNom() + " | " + agence.getVille() + " | " + agence.getAdresse());
        }
    }

    @Test
    public void createAgence() {
        Agence agence = new Agence();
        agence.setNom("Agence Sfax");
        agence.setVille("Sfax");
        agence.setAdresse("12 Avenue Bourguiba");
        agence.setTelephone("74123456");

        Agence created = agenceService.create(agence);

        System.out.println("Agence créée : " + created.getIdAgence() + " | " + created.getNom() + " | " + created.getVille());
    }
}

@Repository
interface AgenceRepositoryMock extends CrudRepository<Agence, Long> {
}
