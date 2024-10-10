package com.dh.ClinicaOdontologicaII.service;

import com.dh.ClinicaOdontologicaII.entities.Dentist;
import com.dh.ClinicaOdontologicaII.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    private DentistRepository repository;

    @Autowired
    public DentistService(DentistRepository repository) {
        this.repository = repository;
    }


    public Dentist save(Dentist dentist) {
        return repository.save(dentist);
    }

    public Optional<Dentist> findById (Integer id) {
        return repository.findById(id);
    }

    public void update (Dentist dentist) {
        repository.save(dentist);
    }

    public void delete (Integer id) {
        repository.deleteById(id);
    }

    public List<Dentist> findAll () {
        return  repository.findAll();
    }

}

