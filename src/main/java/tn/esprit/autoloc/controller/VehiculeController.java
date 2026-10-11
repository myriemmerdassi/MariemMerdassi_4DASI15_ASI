package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/vehicule")
@RequiredArgsConstructor
public class VehiculeController {

    final IVehiculeService vehiculeService;

    @GetMapping("/retrieve-all-vehicules")
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @GetMapping("/retrieve-vehicule/{id}")
    public Vehicule retrieveVehicule(@PathVariable("id") Long idVehicule) {
        return vehiculeService.retrieveVehicule(idVehicule);
    }

    @PostMapping("/add-vehicule")
    public Vehicule addVehicule(@RequestBody Vehicule c) {
        return vehiculeService.addVehicule(c);
    }

    @PostMapping("/add-vehicules")
    public List<Vehicule> addVehicules(@RequestBody List<Vehicule> list) {
        return vehiculeService.addVehicules(list);
    }

    @PutMapping("/update-vehicule")
    public Vehicule updateVehicule(@RequestBody Vehicule c) {
        return vehiculeService.updateVehicule(c);
    }

    @DeleteMapping("/remove-vehicule/{id}")
    public void removeVehicule(@PathVariable("id") Long idVehicule) {
        vehiculeService.removeVehicule(idVehicule);
    }
}
