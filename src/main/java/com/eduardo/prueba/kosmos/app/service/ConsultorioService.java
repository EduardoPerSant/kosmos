package com.eduardo.prueba.kosmos.app.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eduardo.prueba.kosmos.app.domain.entity.Consultorio;
import com.eduardo.prueba.kosmos.app.facade.ConsultorioFacade;
import com.eduardo.prueba.kosmos.app.web.model.ConsultorioModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ConsultorioService {

    private final ConsultorioFacade consultorioFacade; 
    
    /**
     * Method to create a new consultorio.
     * This method checks if a consultorio with the same number and floor already exists.
     * @param consultorio the consultorio to create.
     */
    public ConsultorioModel createConsultorio(ConsultorioModel model) {
        log.info("Creating consultorio: {}", model);
        Optional<Consultorio> entity = consultorioFacade.getByNumeroAndPiso(model.getNumero(), model.getPiso());
        if (entity.isPresent()) {
            log.error("Consultorio with number {} and floor {} already exists", model.getNumero(), model.getPiso());
            return null;
            
        }
        model.setFechaRegistro(java.time.LocalDateTime.now());
        Consultorio consultorioEntity = model.toEntity();
        consultorioEntity = consultorioFacade.saveConsultorio(consultorioEntity);
        return consultorioEntity.toModel();
    }

    /**
     * Method to retrieve a consultorio by its ID.
     * @param id the ID of the consultorio to retrieve.
     * @return the consultorio with the specified ID.
     */
    public ConsultorioModel getConsultorioById(Long id) {
        log.info("Fetching consultorio with id: {}", id);
        Consultorio consultorio = consultorioFacade.getConsultorioById(id);
        if (consultorio == null) {
            log.error("Consultorio with id {} not found", id);
            return null;
        }
        return consultorio.toModel();
    }

    /**
     * Method to update an existing consultorio.
     * @param id the ID of the consultorio to update.
     * @param consultorio the updated consultorio data.
     */
    public ConsultorioModel updateConsultorio(Long id, ConsultorioModel consultorio) {
        log.info("Updating consultorio with id: {}", id);
        Consultorio existingConsultorio = consultorioFacade.getConsultorioById(id);
        if (existingConsultorio == null) {
            log.error("Consultorio with id {} not found", id);
            return null;
        }
        consultorio.setId(id);
        consultorio.setFechaModificacion(LocalDateTime.now());
        consultorioFacade.updateConsultorio(consultorio.toEntity());
        return consultorio;
    }

    /**
     * Method to delete a consultorio by its ID.
     * @param id the ID of the consultorio to delete.
     */
    public ConsultorioModel deleteConsultorio(Long id) {
        log.info("Deleting consultorio with id: {}", id);
        Consultorio existingConsultorio = consultorioFacade.getConsultorioById(id);
        if (existingConsultorio == null) {
            log.error("Consultorio with id {} not found", id);
            return null;
        }
        consultorioFacade.deleteConsultorio(id);
        return existingConsultorio.toModel();
    }
}
