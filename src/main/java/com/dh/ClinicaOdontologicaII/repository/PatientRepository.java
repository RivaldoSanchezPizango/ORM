package com.dh.ClinicaOdontologicaII.repository;

import com.dh.ClinicaOdontologicaII.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {



}
