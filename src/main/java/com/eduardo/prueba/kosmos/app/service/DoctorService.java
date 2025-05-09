

package com.eduardo.prueba.kosmos.app.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.eduardo.prueba.kosmos.app.domain.entity.Doctor;
import com.eduardo.prueba.kosmos.app.facade.DoctorFacade;
import com.eduardo.prueba.kosmos.app.web.model.DoctorModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * Service class for managing Doctor entities.
 * This class provides methods to create, retrieve, update, and delete Doctor entities.
 * It uses the DoctorFacade to perform these operations.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@RequiredArgsConstructor
@Service
@Log4j2
public class DoctorService {

    private final DoctorFacade doctorFacade;

    /**
     * Method to create a new doctor.
     * @param doctor the doctor to create.
     */
    public DoctorModel createDoctor(DoctorModel doctor) {
        log.info("Creating a new doctor: {}", doctor);
        doctor.setFechaRegistro(LocalDateTime.now());
        Doctor doctorEntity = doctor.toEntity();
        doctorEntity = doctorFacade.saveDoctor(doctorEntity);
        return doctorEntity.toModel();
    }

    /**
     * Method to retrieve a doctor by their ID.
     * @param id the ID of the doctor to retrieve.
     * @return the doctor with the specified ID.
     */
    public DoctorModel getDoctorById(Long id) {
        log.info("Fetching doctor with id: {}", id);
        Doctor doctor = doctorFacade.getDoctorById(id);
        if (doctor == null) {
            log.error("Doctor with id {} not found", id);
            return null;
        }
        return doctor.toModel();
    }

    /**
     * Method to update an existing doctor.
     * @param doctor the doctor to update.
     */
    public DoctorModel updateDoctor(Long id, DoctorModel doctor) {
        log.info("Updating doctor with id: {}", id);
        Doctor existingDoctor = doctorFacade.getDoctorById(id);
        if (existingDoctor == null) {
            log.error("Doctor with id {} not found", id);
            return null;
        }
        doctor.setId(id);
        doctor.setFechaModificacion(LocalDateTime.now());
        doctorFacade.updateDoctor(doctor.toEntity());
        return doctor;
    }

    /**
     * Method to delete a doctor by their ID.
     * @param id the ID of the doctor to delete.
     */
    public DoctorModel deleteDoctor(Long id) {
        log.info("Deleting doctor with id: {}", id);
        Doctor existingDoctor = doctorFacade.getDoctorById(id);
        if (existingDoctor == null) {
            log.error("Doctor with id {} not found", id);
            return null;
        }
        doctorFacade.deleteDoctor(id);
        return existingDoctor.toModel();
    }

}
