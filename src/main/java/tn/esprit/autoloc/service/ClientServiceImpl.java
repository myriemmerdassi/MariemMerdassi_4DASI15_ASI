package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Utils;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.IClientRepository;

@Service
public class ClientServiceImpl extends GenericServiceImpl<Client, Long> implements IClientService {

    public ClientServiceImpl(IClientRepository clientRepository) {
        super(clientRepository);
    }

    @Override
    protected String getEntityName() {
        return "Client";
    }

    @Override
    protected Long getId(Client entity) {
        return entity.getIdClient();
    }

    @Override
    protected void setFields(Client existing, Client entity) {
        existing.setNom(entity.getNom());
        existing.setPrenom(entity.getPrenom());
        existing.setEmail(entity.getEmail());
        existing.setTelephone(entity.getTelephone());
        existing.setNumPermis(entity.getNumPermis());
        existing.setDateInscription(entity.getDateInscription());
    }

    @Override
    public boolean check(Client client, boolean isNew) {
        return client != null
                && Utils.isNotEmpty(client.getNom())
                && Utils.isNotEmpty(client.getPrenom())
                && Utils.isNotEmpty(client.getEmail());
    }
}
