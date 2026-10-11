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
        return clientService.retrieveAllClients();
    }

    @GetMapping("/retrieve-client/{id}")
    public Client retrieveClient(@PathVariable("id") Long idClient) {
        return clientService.retrieveClient(idClient);
    }

    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client c) {
        return clientService.addClient(c);
    }

    @PostMapping("/add-clients")
    public List<Client> addClients(@RequestBody List<Client> list) {
        return clientService.addClients(list);
    }

    @PutMapping("/update-client")
    public Client updateClient(@RequestBody Client c) {
        return clientService.updateClient(c);
    }

    @DeleteMapping("/remove-client/{id}")
    public void removeClient(@PathVariable("id") Long idClient) {
        clientService.removeClient(idClient);
    }
}
