package com.eduardo.prueba.kosmos.app.facade;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eduardo.prueba.kosmos.app.domain.entity.Paciente;
import com.eduardo.prueba.kosmos.app.domain.repository.PacienteRepository;

import lombok.RequiredArgsConstructor;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PacienteFacade {

    private final PacienteRepository pacienteRepository;

    /**
     * Method to get a patient by their ID.
     * @param idPaciente the ID of the patient to retrieve.
     * @return the patient with the specified ID.
     */
    public Paciente getPacienteById(Long idPaciente) {
        return pacienteRepository.findById(idPaciente).orElse(null);
    }

    /**
     * Method to get a patient by their name and last names.
     * @param nombre the name of the patient.
     * @param apellidoPaterno the paternal last name of the patient.
     * @param apellidoMaterno the maternal last name of the patient.
     * @return an Optional containing the patient if found, or empty if not found.
     */
    public Optional<Paciente> getByNameAndLastNames(String nombre, String apellidoPaterno, String apellidoMaterno) {
        return pacienteRepository.findByNombreAndApellidoPAternoandApellidoMaterno(nombre, apellidoPaterno, apellidoMaterno);
    }


    /**
     * Method to save a patient.
     * @param paciente the patient to save.
     * @return the saved patient.
     */
    @Transactional(readOnly = false)
    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    /**
     * Method to update a patient.
     * This method is used to update the information of an existing patient.
     * @param paciente the patient to update.
     * @return the updated patient.
     */
    @Transactional(readOnly = false)
    public Paciente updatePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    /**
     * Method to delete a patient by their ID.
     * @param idPaciente the ID of the patient to delete.
     */
    @Transactional(readOnly = false)
    public void deletePaciente(Long idPaciente) {
        pacienteRepository.deleteById(idPaciente);
    }
}
