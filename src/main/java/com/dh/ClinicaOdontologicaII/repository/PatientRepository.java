package com.dh.ClinicaOdontologicaII.repository;

import com.dh.ClinicaOdontologicaII.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query("SELECT p from Patient p where p.lastName=?1")
    Optional<Patient> findByLastName(String lastName);

    Optional<Patient> findByName(String name);

}
