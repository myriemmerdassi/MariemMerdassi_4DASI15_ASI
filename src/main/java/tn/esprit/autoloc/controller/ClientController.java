package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    final IClientService clientService;

    @GetMapping("/retrieve-all-clients")
    public List<Client> retrieveAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/retrieve-client/{id}")
    public Client retrieveClient(@PathVariable("id") Long idClient) {
        return clientService.findById(idClient);
    }

    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client c) {
        return clientService.create(c);
    }

    @PutMapping("/update-client")
    public Client updateClient(@RequestBody Client c) {
        return clientService.update(c.getIdClient(), c);
    }

    @DeleteMapping("/remove-client/{id}")
    public void removeClient(@PathVariable("id") Long idClient) {
        clientService.deleteById(idClient);
    }
}
