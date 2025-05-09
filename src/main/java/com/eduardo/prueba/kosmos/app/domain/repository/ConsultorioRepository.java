package com.eduardo.prueba.kosmos.app.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.prueba.kosmos.app.domain.entity.Consultorio;

/**
 * Repository class for managing consultation room entities.
 * This class provides methods to interact with the Consultorio entity.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {

    /**
     * Method to find a consultation room by its number and floor.
     * @param numeroConsultorio the number of the consultation room.
     * @param piso the floor of the consultation room.
     * @return an Optional containing the found consultation room, or empty if not found.
     */
    Optional<Consultorio> findByNumeroAndPiso(String numeroConsultorio, Long piso);
    
}
