package com.dh.ClinicaOdontologicaII.controller;

import com.dh.ClinicaOdontologicaII.entities.Dentist;
import com.dh.ClinicaOdontologicaII.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    // @PostMapping Vamos a crear un odontologo
    @PostMapping ("/save")
    public Dentist save (@RequestBody Dentist dentist) {
        return dentistService.save(dentist);
    }

    // Listar todos los odontologos
    @GetMapping("/all")
    public List<Dentist> getAll () {
        return dentistService.findAll();
    }

    // Buscar por ID un odontologo
    @GetMapping("/id/{id}")
    public ResponseEntity<Dentist> findById(@PathVariable Integer id) {
        Optional<Dentist> dentistWanted = dentistService.findById(id);
        if (dentistWanted.isPresent()) {
            return ResponseEntity.ok(dentistWanted.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Actualizar un odontologo
    @PutMapping("/update")
    public Dentist update (@RequestBody Dentist dentist) {
        Optional<Dentist> optionalDentist = dentistService.findById(dentist.getId());

        if (optionalDentist.isPresent()) {
            dentistService.update(dentist);
            return dentist;
        } else {
            return dentist;
        }
    }

    // Con @DeleteMapping estamos eliminando un odontologo de la Base de Datos
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Optional<Dentist> optionalDentist = dentistService.findById(id);
        if (optionalDentist.isPresent()) {
            dentistService.delete(id);
            return "Se elimino el odontologo con ID: " + id;
        } else {
            return "No se encontro el odontologo con ID: " + id;
        }
    }

}
