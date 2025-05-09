package com.eduardo.prueba.kosmos.app.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.eduardo.prueba.kosmos.app.domain.entity.Paciente;
import com.eduardo.prueba.kosmos.app.facade.PacienteFacade;
import com.eduardo.prueba.kosmos.app.web.model.PacienteModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PacienteService {

    private final PacienteFacade pacienteFacade;

    /**
     * Method to create a new Paciente.
     * @param paciente the Paciente to create.
     * @return the created Paciente.
     */
    public PacienteModel createPaciente(PacienteModel paciente) {
        log.info("Creating a new Paciente: {}", paciente);
        pacienteFacade.getByNameAndLastNames(paciente.getNombre(), paciente.getApellidoPaterno(), paciente.getApellidoMaterno());
        if (pacienteFacade.getByNameAndLastNames(paciente.getNombre(), paciente.getApellidoPaterno(), paciente.getApellidoMaterno()).isPresent()) {
            log.error("Paciente with name {} and last names {} already exists", paciente.getNombre(), paciente.getApellidoPaterno());
            return null;
        }
        paciente.setFechaRegistro(LocalDateTime.now());
        Paciente pacienteEntity = paciente.toEntity();
        pacienteEntity = pacienteFacade.savePaciente(pacienteEntity);
        return pacienteEntity.toModel();
    }

    /**
     * Method to retrieve a Paciente by their ID.
     * @param id the ID of the Paciente to retrieve.
     * @return the Paciente with the specified ID.
     */
    public PacienteModel getPacienteById(Long id) {
        log.info("Fetching Paciente with id: {}", id);
        Paciente paciente = pacienteFacade.getPacienteById(id);
        if (paciente == null) {
            log.error("Paciente with id {} not found", id);
            return null;
        }
        return paciente.toModel();
    }

    /**
     * Method to update an existing Paciente.
     * @param id the ID of the Paciente to update.
     * @param paciente the updated Paciente data.
     */
    public PacienteModel updatePaciente(Long id, PacienteModel paciente) {
        log.info("Updating Paciente with id: {}", id);
        Paciente pacienteExist = pacienteFacade.getPacienteById(id);
        if (pacienteExist == null) {
            log.error("Paciente with id {} not found", id);
            return null;
        }
        paciente.setId(id);
        paciente.setFechaRegistro(pacienteExist.getFechaRegistro());
        pacienteFacade.updatePaciente(paciente.toEntity());
        return paciente;
    }

    /**
     * Method to delete a Paciente by their ID.
     * @param id the ID of the Paciente to delete.
     */
    public PacienteModel deletePaciente(Long id) {
        log.info("Deleting Paciente with id: {}", id);
        Paciente pacienteExist = pacienteFacade.getPacienteById(id);
        if (pacienteExist == null) {
            log.error("Paciente with id {} not found", id);
            return null;
        }
        pacienteFacade.deletePaciente(id);
        return pacienteExist.toModel();
    }
}
