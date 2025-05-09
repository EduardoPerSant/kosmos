package com.eduardo.prueba.kosmos.app.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.prueba.kosmos.app.domain.entity.Paciente;

/**
 * Repository interface for managing patient entities.
 * This interface extends JpaRepository to provide CRUD operations for the Paciente entity.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    /**
     * Method to find a patient by their name and last names.
     * @param nombre the name of the patient.
     * @param apellidoPaterno the paternal last name of the patient.
     * @param apellidoMaterno the maternal last name of the patient.
     * @return an Optional containing the found patient, or empty if not found.
     */
    Optional<Paciente> findByNombreAndApellidoPAternoandApellidoMaterno(String nombre,String apellidoPaterno, String apellidoMaterno);

}
