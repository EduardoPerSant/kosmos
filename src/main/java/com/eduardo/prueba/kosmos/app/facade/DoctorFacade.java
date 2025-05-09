package com.eduardo.prueba.kosmos.app.facade;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eduardo.prueba.kosmos.app.domain.entity.Doctor;
import com.eduardo.prueba.kosmos.app.domain.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;

/**
 * Facade class for managing doctor-related operations.
 * This class provides methods to interact with the Doctor entity.
 * It uses the DoctorRepository to perform CRUD operations.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DoctorFacade {
    
    private final DoctorRepository doctorRepository;

    /**
     * Method to get a doctor by their ID.
     * @param idDoctor the ID of the doctor to retrieve.
     * @return the doctor with the specified ID.
     */
    public Doctor getDoctorById(Long idDoctor) {
        return doctorRepository.findById(idDoctor).orElse(null);
    }

    /**
     * Method to save a doctor.
     * @param doctor the doctor to save.
     * @return the saved doctor.
     */
    @Transactional(readOnly = false)
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    /**
     * Mehod to update a doctor.
     * This method is used to update the information of an existing doctor.
     * @param doctor
     * @return the updated doctor.
     */
    @Transactional(readOnly = false)
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    /**
     * Method to delete a doctor by their ID.
     * @param idDoctor the ID of the doctor to delete.
     */
    @Transactional(readOnly = false)
    public void deleteDoctor(Long idDoctor) {
        doctorRepository.deleteById(idDoctor);
    }
}
