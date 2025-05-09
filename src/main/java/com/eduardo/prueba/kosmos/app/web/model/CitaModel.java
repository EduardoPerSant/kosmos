package com.eduardo.prueba.kosmos.app.web.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.eduardo.prueba.kosmos.app.domain.entity.Cita;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model class representing an appointment.
 * This class is used for API responses and requests.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "CitaModel", description = "Model representing an appointment.")
public class CitaModel implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID of the appointment", example = "1", required = false)
    private Long id;

    @ApiModelProperty(value = "Date of the appointment", example = "2025-05-09", required = true)
    private LocalDate fecha;

    @ApiModelProperty(value = "Time of the appointment", example = "10:00", required = true)
    private LocalTime horario;

    @ApiModelProperty(value = "ID of the doctor", example = "1", required = false)
    private Long idDoctor;

    @ApiModelProperty(value = "ID of the consultation room", example = "1", required = false)
    private Long idConsultorio;

    @ApiModelProperty(value = "Name of the patient", example = "Eduardo Pérez", required = true)
    private Long idPaciente;
    
    @ApiModelProperty(value = "Date of registration", example = "2025-05-09", required = false)
    private LocalDateTime fechaRegistro;

    @ApiModelProperty(value = "Date of modification", example = "2025-05-09", required = false)
    private LocalDateTime fechaModificacion;

    public Cita toEntity() {
        Cita cita = new Cita();
        cita.setId(this.id);
        cita.setFecha(this.fecha);
        cita.setHorario(this.horario);
        cita.setIdDoctor(this.idDoctor);
        cita.setIdConsultorio(this.idConsultorio);
        cita.setIdPaciente(this.idPaciente);
        cita.setFechaRegistro(this.fechaRegistro);
        cita.setFechaModificacion(this.fechaModificacion);
        return cita;
    }
    
}
