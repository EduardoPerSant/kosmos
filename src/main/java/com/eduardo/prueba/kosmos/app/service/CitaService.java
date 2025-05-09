package com.eduardo.prueba.kosmos.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eduardo.prueba.kosmos.app.domain.entity.Cita;
import com.eduardo.prueba.kosmos.app.facade.CitaFacade;
import com.eduardo.prueba.kosmos.app.utils.Constantes;
import com.eduardo.prueba.kosmos.app.web.model.CitaModel;
import com.eduardo.prueba.kosmos.app.web.model.ConsultorioModel;
import com.eduardo.prueba.kosmos.app.web.model.DoctorModel;
import com.eduardo.prueba.kosmos.app.web.model.PacienteModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * Service class for managing Cita entities.
 * This class provides methods to create, retrieve, update, and delete Cita entities.
 * It uses the CitaFacade to perform these operations.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class CitaService {

    private final CitaFacade citaFacade;
    private final DoctorService doctorService;
    private final PacienteService pacienteService;
    private final ConsultorioService consultorioService;

    /**
     * Method to create a new Cita.
     * @param cita the Cita to create.
     * @return the created Cita.
     */
    public CitaModel createCita(CitaModel newCita) throws Exception{
        log.info("Creating a new Cita: {}", newCita);
        
        this.validateMembers(newCita.getIdDoctor(), newCita.getIdConsultorio(), newCita.getIdPaciente());

        if (newCita.getFecha().isBefore(LocalDate.now())) {
            log.error("The date of the appointment cannot be in the past");
            throw new Exception("La fecha de la cita no puede ser menor a la fecha actual");
        }
        Optional<Cita> cita = citaFacade.findByIdPacienteAndFecha(newCita.getIdPaciente(), newCita.getFecha());
        if (cita.isPresent()) {
            Cita citaExist = cita.get();
            LocalTime newHorario = newCita.getHorario().minusHours(Constantes.MINIMO_HORAS_ENTRE_CITAS);
            if(newHorario.isBefore(citaExist.getHorario())) {
                log.error("Cita already exists for doctor {}, consultorio {}, and patient {} with time {}", newCita.getIdDoctor(), newCita.getIdConsultorio(), newCita.getIdPaciente(), citaExist.getHorario());
                throw new Exception("Ya existe una cita en el horario " + citaExist.getHorario().getHour() + ":" + citaExist.getHorario().getMinute() + " para el paciente.");
            }
            if (newHorario.equals(citaExist.getHorario())){
                log.error("Cita is too close to the existing appointment");
                throw new Exception("La cita es muy pronta a la cita existente, debe esperar al menos " + Constantes.MINIMO_HORAS_ENTRE_CITAS + " horas entre citas");
            }
        }
        if (Boolean.FALSE.equals(this.isDoctorFree(newCita.getIdDoctor(), newCita.getFecha(), newCita.getHorario()))) {
            log.error("Doctor is not available for the selected date and time");
            throw new Exception("El doctor no esta disponible en la fecha y hora seleccionada");
        }
        if (Boolean.FALSE.equals(this.isConsultorioFree(newCita.getIdConsultorio(), newCita.getFecha(), newCita.getHorario().toString()))) {
            log.error("Consultorio is not available for the selected date and time");
            throw new Exception("El consultorio no esta disponible en la fecha y hora seleccionada");
        }
        Cita entity = citaFacade.saveCita(newCita.toEntity());
        return entity.toModel();
    }

    /**
     * Method to validate the existence of a doctor, consultorio, and paciente.
     * @param idDoctor
     * @param idConsultorio
     * @param idPaciente
     */
    private void validateMembers(Long idDoctor, Long idConsultorio, Long idPaciente) throws Exception {
        ConsultorioModel consultorio = consultorioService.getConsultorioById(idConsultorio);
        if(Objects.isNull(consultorio)) {
            log.error("Consultorio with id {} not found", idConsultorio);
            throw new Exception("No se encontro el consultorio seleccionado");
        }
        DoctorModel doctor = doctorService.getDoctorById(idDoctor);
        if(Objects.isNull(doctor)) {
            log.error("Doctor with id {} not found", idDoctor);
            throw new Exception("No se encontro el Doctor seleccionado");
        }
        PacienteModel paciente = pacienteService.getPacienteById(idPaciente);
        if (Objects.isNull(paciente)) {
            log.error("Paciente with id {} not found", idPaciente);
            throw new Exception("No se encontro al Paciente");
        }
    }

    /**
     * Method to retrieve a Cita by its ID.
     * @param id the ID of the Cita to retrieve.
     * @return the Cita with the specified ID.
     */
    public CitaModel getCitaById(Long id) {
        log.info("Retrieving Cita with id: {}", id);
        Cita cita = citaFacade.getCitaById(id);
        if (cita == null) {
            log.error("Cita with id {} not found", id);
            return null;
        }   
        return cita.toModel();
    }

    /**
     * Method to update an existing Cita.
     * @param id the ID of the Cita to update.
     * @param cita the updated Cita data.
     */
    public CitaModel updateCita(Long id, CitaModel cita) {
        log.info("Updating Cita with id: {}", id);
        Cita citaExist = citaFacade.getCitaById(id);
        if (citaExist == null) {
            log.error("Cita with id {} not found", id);
            return null;
        }
        cita.setId(id);
        citaFacade.updateCita(cita.toEntity());
        return cita;
    }

    /**
     * Method to delete a Cita by its ID.
     * @param id the ID of the Cita to delete.
     */
    public void deleteCita(Long id) {
        log.info("Deleting Cita with id: {}", id);
        Cita citaExist = citaFacade.getCitaById(id);
        if (citaExist == null) {
            log.error("Cita with id {} not found", id);
            return;
        }
        citaFacade.deleteCita(id);
    }

    /**
     * Method to check if a doctor is free for a specific date and time.
     * @param idDoctor the ID of the doctor.
     * @param fecha the date of the appointment.
     * @param horario the time of the appointment.
     */
    public boolean isDoctorFree(Long idDoctor, LocalDate fecha, LocalTime horario) {
        log.info("Checking if doctor is free: {}", idDoctor);
        Optional<Cita> cita = citaFacade.findByIdDoctorAndAndFechaAndHorario(idDoctor, fecha, horario);
        if (cita.isPresent()) {
            log.error("Doctor is not free");
            return false;
        }
        Long citasAgendadas = citaFacade.countByIdDoctorAndFecha(idDoctor, fecha);
        if (citasAgendadas >= Constantes.MAXIMO_CITAS_AGENDADAS) {
            log.error("Doctor has already scheduled appointments for this date");
            return false;
        }
        return true;
    }

    /**
     * Method to check if a consultorio is free for a specific date and time.
     * @param idConsultorio the ID of the consultorio.
     * @param fecha the date of the appointment.
     * @param horario the time of the appointment.
     */
    public boolean isConsultorioFree(Long idConsultorio, LocalDate fecha, String horario) {
        log.info("Checking if consultorio is free: {}", idConsultorio);
        Optional<Cita> cita = citaFacade.findByIdConsultorioAndFechaAndHorario(idConsultorio, fecha, horario);
        if (cita.isPresent()) {
            log.error("Consultorio is not free");
            return false;
        }
        return true;
    }
}
