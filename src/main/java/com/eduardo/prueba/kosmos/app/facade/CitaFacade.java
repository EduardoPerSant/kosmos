package com.eduardo.prueba.kosmos.app.facade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eduardo.prueba.kosmos.app.domain.entity.Cita;
import com.eduardo.prueba.kosmos.app.domain.repository.CitaRepository;

import lombok.RequiredArgsConstructor;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CitaFacade {

    private final CitaRepository citaRepository;
    
    /**
     * Method to get a Cita by its ID.
     * @param idCita the ID of the Cita to retrieve.
     * @return the Cita with the specified ID.
     */
    public Cita getCitaById(Long idCita) {
        return citaRepository.findById(idCita).orElse(null);
    }
    /**
     * Method to save a Cita.
     * @param cita the Cita to save.
     * @return the saved Cita.
     */
    @Transactional(readOnly = false)
    public Cita saveCita(Cita cita) {
        return citaRepository.save(cita);
    }

    /**
     * Method to update a Cita.
     * This method is used to update the information of an existing Cita.
     * @param cita the Cita to update.
     * @return the updated Cita.
     */
    @Transactional(readOnly = false)
    public Cita updateCita(Cita cita) {
        return citaRepository.save(cita);
    }

    /**
     * Method to delete a Cita by its ID.
     * @param idCita the ID of the Cita to delete.
     */
    @Transactional(readOnly = false)
    public void deleteCita(Long idCita) {
        citaRepository.deleteById(idCita);
    }

    /**
     * Method to find a Cita by its doctor ID, consultorio ID, and patient ID.
     * @param idDoctor the ID of the doctor.
     * @param idConsultorio the ID of the consultorio.
     * @param idPaciente the ID of the patient.
     * @return the Cita with the specified IDs, or null if not found.
     */
    public Optional<Cita> findByIdDoctorAndIdConsultorioAndIdPaciente(Long idDoctor, Long idConsultorio, Long idPaciente) {
        return citaRepository.findByIdDoctorAndIdConsultorioAndIdPaciente(idDoctor, idConsultorio, idPaciente);
    }

    /**
     * Method to find a Cita by its doctor ID, consultorio ID, patient ID, and date.
     * @param idDoctor the ID of the doctor.
     * @param idConsultorio the ID of the consultorio.
     * @param idPaciente the ID of the patient.
     * @param fecha the date of the appointment.
     * @return the Cita with the specified IDs and date, or null if not found.
     */
    public Optional<Cita> findByIdDoctorAndIdConsultorioAndIdPacienteAndFecha(Long idDoctor, Long idConsultorio, Long idPaciente, LocalDate fecha) {
        return citaRepository.findByIdDoctorAndIdConsultorioAndIdPacienteAndFecha(idDoctor, idConsultorio, idPaciente, fecha);
    }

    /**
     * Method to find a Cita by its doctor ID, consultorio ID, and date.
     * @param idDoctor the ID of the doctor.
     * @param idConsultorio the ID of the consultorio.
     * @param fecha the date of the appointment.
     * @return the Cita with the specified IDs and date, or null if not found.
     */
    public Optional<Cita> findByIdDoctorAndAndFechaAndHorario(Long idDoctor, LocalDate fecha, LocalTime horario) {
        return citaRepository.findByIdDoctorAndAndFechaAndHorario(idDoctor, fecha, horario);
    }

    /**
     * Method to find a Cita by its consultorio ID and date.
     * @param idConsultorio the ID of the consultorio.
     * @param fecha the date of the appointment.
     * @return the Cita with the specified consultorio ID and date, or null if not found.
     */
    public Optional<Cita> findByIdConsultorioAndFechaAndHorario(Long idConsultorio, LocalDate fecha, String horario) {
        return citaRepository.findByIdConsultorioAndFechaAndHorario(idConsultorio, fecha, horario);
    }

    /**
     * Method to count the number of appointments for a specific doctor on a given date.
     * @param idDoctor the ID of the doctor.
     * @param fecha the date of the appointments.
     * @return the count of appointments for the specified doctor and date.
     */
    public long countByIdDoctorAndFecha(Long idDoctor, LocalDate fecha) {
        return citaRepository.countByIdDoctorAndFecha(idDoctor, fecha);
    }

    /**
     * Method to find a Cita by its patient ID and date.
     * @param idPaciente the ID of the patient.
     * @param fecha the date of the appointment.
     * @return the Cita with the specified patient ID and date, or null if not found.
     */
    public Optional<Cita> findByIdPacienteAndFecha(Long idPaciente, LocalDate fecha) {
        return citaRepository.findByIdPacienteAndFecha(idPaciente, fecha);
    }
}
