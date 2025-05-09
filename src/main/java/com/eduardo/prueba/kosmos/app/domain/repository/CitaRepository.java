package com.eduardo.prueba.kosmos.app.domain.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.prueba.kosmos.app.domain.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    /**
     * Method to find a Cita by its doctor ID, consultorio ID, patient ID, and date.
     * @param idDoctor the ID of the doctor.
     * @param idConsultorio the ID of the consultorio.
     * @param idPaciente the ID of the patient.
     * @return an Optional containing the found Cita, or empty if not found.
     */
    Optional<Cita> findByIdDoctorAndIdConsultorioAndIdPaciente(Long idDoctor, Long idConsultorio, Long idPaciente);
    
    /**
     * Method to find a Cita by its doctor ID, consultorio ID, patient ID, and date.
     * @param idDoctor the ID of the doctor.
     * @param idConsultorio the ID of the consultorio.
     * @param idPaciente the ID of the patient.
     * @param fecha the date of the appointment.
     * @return an Optional containing the found Cita, or empty if not found.
     */
    Optional<Cita> findByIdDoctorAndIdConsultorioAndIdPacienteAndFecha(Long idDoctor, Long idConsultorio, Long idPaciente, LocalDate fecha);

    /**
     * Method to find a Cita by its doctor ID, consultorio ID, and date.
     * @param idDoctor the ID of the doctor.
     * @param idConsultorio the ID of the consultorio.
     * @param fecha the date of the appointment.
     * @return an Optional containing the found Cita, or empty if not found.
     */
    Optional<Cita> findByIdDoctorAndAndFechaAndHorario(Long idDoctor, LocalDate fecha, LocalTime horario);

    /**
     * Method to find a Cita by its consultorio ID and date.
     * @param idConsultorio the ID of the consultorio.
     * @param fecha the date of the appointment.
     * @return an Optional containing the found Cita, or empty if not found.
     */
    Optional<Cita> findByIdConsultorioAndFechaAndHorario(Long idConsultorio, LocalDate fecha, String horario);


    /**
     * Method to count the number of appointments for a specific doctor on a given date.
     * @param idDoctor the ID of the doctor.
     * @param fecha the date of the appointments.
     * @return the count of appointments for the specified doctor and date.
     */
    long countByIdDoctorAndFecha(Long idDoctor, LocalDate fecha);

    /**
     * Method to find a Cita by its patient ID and date.
     * @param idPaciente the ID of the patient.
     * @param fecha the date of the appointment.
     * @return an Optional containing the found Cita, or empty if not found.
     */
    Optional<Cita> findByIdPacienteAndFecha(Long idPaciente, LocalDate fecha);
    
}
