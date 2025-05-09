package com.eduardo.prueba.kosmos.app.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eduardo.prueba.kosmos.app.web.model.CitaModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing an appointment.
 * This class is mapped to the "citas" table in the database.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Getter
@Setter
@NoArgsConstructor
@Table(name = "citas")
@Entity
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fecha_consulta")
    private LocalDate fecha;

    @Column(name = "horario_consulta")
    private LocalTime horario;

    @Column(name = "id_doctor",nullable = false)
    private Long idDoctor;

    @Column(name = "id_consultorio")
    private Long idConsultorio;

    @Column(name = "id_paciente")
    private Long idPaciente;
    
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor",nullable = false,
            foreignKey = @ForeignKey(name = "FK_CITAS_DOCTOR"),
             insertable = false, updatable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consultorio",nullable = false,
            foreignKey = @ForeignKey(name = "FK_CITAS_CONSULTORIO"),
             insertable = false, updatable = false)
    private Consultorio consultorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente",nullable = false,
            foreignKey = @ForeignKey(name = "FK_CITAS_PACIENTE"),
             insertable = false, updatable = false)
    private Paciente paciente;

    /**
     * Converts this entity to a CitaModel.
     * @return CitaModel representation of this entity.
     */
    public CitaModel toModel() {
        CitaModel citaModel = new CitaModel();
        citaModel.setId(this.id);
        citaModel.setFecha(this.fecha);
        citaModel.setHorario(this.horario);
        citaModel.setIdDoctor(this.idDoctor);
        citaModel.setIdConsultorio(this.idConsultorio);
        citaModel.setIdPaciente(this.idPaciente);
        citaModel.setFechaRegistro(this.fechaRegistro);
        citaModel.setFechaModificacion(this.fechaModificacion);
        return citaModel;
    }
}
