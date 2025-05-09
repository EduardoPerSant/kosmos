package com.eduardo.prueba.kosmos.app.facade;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eduardo.prueba.kosmos.app.domain.entity.Consultorio;
import com.eduardo.prueba.kosmos.app.domain.repository.ConsultorioRepository;

import lombok.RequiredArgsConstructor;

/**
 * Facade class for managing consultation rooms.
 * This class provides methods to interact with the Consultorio entity.
 * It uses the ConsultorioRepository to perform CRUD operations.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ConsultorioFacade {
    
    private final ConsultorioRepository consultorioRepository;

    /**
     * Method to get a consultation room by its ID.
     * @param idConsultorio the ID of the consultation room to retrieve.
     * @return the consultation room with the specified ID.
     */
    public Consultorio getConsultorioById(Long idConsultorio) {
        return consultorioRepository.findById(idConsultorio).orElse(null);
    }

    /**
     * Method to get a consultation room by its number and floor.
     * @param numero
     * @param piso
     * @return the consultation room with the specified number and floor.
     */
    public Optional<Consultorio> getByNumeroAndPiso(String numero, Long piso) {
        return consultorioRepository.findByNumeroAndPiso(numero, piso);
    }

    /**
     * Method to save a consultation room.
     * @param consultorio the consultation room to save.
     * @return the saved consultation room.
     */
    @Transactional(readOnly = false)
    public Consultorio saveConsultorio(Consultorio consultorio) {
        return consultorioRepository.save(consultorio);
    }

    /**
     * Method to update a consultation room.
     * This method is used to update the information of an existing consultation room.
     * @param consultorio the consultation room to update.
     * @return the updated consultation room.
     */
    @Transactional(readOnly = false)
    public Consultorio updateConsultorio(Consultorio consultorio) {
        return consultorioRepository.save(consultorio);
    }

    /**
     * Method to delete a consultation room by its ID.
     * @param idConsultorio the ID of the consultation room to delete.
     */
    @Transactional(readOnly = false)
    public void deleteConsultorio(Long idConsultorio) {
        consultorioRepository.deleteById(idConsultorio);
    }
}
