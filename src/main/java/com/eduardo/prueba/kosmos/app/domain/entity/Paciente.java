package com.eduardo.prueba.kosmos.app.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.eduardo.prueba.kosmos.app.web.model.PacienteModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a patient.
 * This class is mapped to the "paciente" table in the database.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Getter
@Setter
@NoArgsConstructor
@Table(name = "paciente")
@Entity
public class Paciente {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    /**
     * Converts this entity to a PacienteModel.
     * @return a PacienteModel with the same properties as this entity.
     */
    public PacienteModel toModel() {
        PacienteModel pacienteModel = new PacienteModel();
        pacienteModel.setId(this.id);
        pacienteModel.setNombre(this.nombre);
        pacienteModel.setApellidoPaterno(this.apellidoPaterno);
        pacienteModel.setApellidoMaterno(this.apellidoMaterno);
        pacienteModel.setFechaRegistro(this.fechaRegistro);
        pacienteModel.setFechaModificacion(this.fechaModificacion);
        // Set other properties as needed
        return pacienteModel;
    }
}
