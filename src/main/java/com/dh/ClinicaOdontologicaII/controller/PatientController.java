package com.dh.ClinicaOdontologicaII.controller;

import com.dh.ClinicaOdontologicaII.entities.Patient;
import com.dh.ClinicaOdontologicaII.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Crea un paciente
    @PostMapping
    public Patient save (@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    // Lista los pacientes
    @GetMapping("/all")
    public List<Patient> getAll () {
        return patientService.findAll();
    }

    // Actualizar un paciente
    @PutMapping("/update")
    public Patient update (@RequestBody  Patient patient) {
        Optional<Patient> optionalPatient = patientService.findById(patient.getId());
        if (optionalPatient.isPresent()) {
            patientService.update(patient);
            return patient;
        } else {
            return patient;
        }
    }

    // Consultarpaciente por ID
    @GetMapping ("/id")
    public Patient findById(@RequestParam Integer id) {
        Optional<Patient> optionalPatient = patientService.findById(id);
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            return null;
        }
    }


    // Elimina paciente por ID
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable Integer id) {
        Optional<Patient> patientWanted = patientService.findById(id);
        if (patientWanted.isPresent()) {
            patientService.delete(id);
            return "Se elimino el paciente con ID: " + id;
        } else {
            return "No se encontro el paciente con ID: " + id;
        }
    }

    // Consultar paciente por apellido
    @GetMapping("/lastname/{lastName}")
    public Patient findByLastname (@PathVariable String lastName) {
        Optional<Patient> patient = patientService.findByLastname(lastName);
        if (patient.isPresent()) {
            return patient.get();
        } else {
            return null;
        }
    }


    // Consultar paciente por Nombre
    @GetMapping("/name/{name}")
    public  Patient findByName (@PathVariable String name) {
        Optional<Patient> patient = patientService.findByName(name);

        if (patient.isPresent()) {
            return patient.get();
        } else {
            return null;
        }

    }

}
