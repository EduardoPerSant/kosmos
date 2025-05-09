package com.eduardo.prueba.kosmos.app.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.eduardo.prueba.kosmos.app.web.model.DoctorModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a doctor.
 * This class is mapped to the "doctores" table in the database.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 * */
@Getter
@Setter
@NoArgsConstructor
@Table(name = "doctor")
@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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
     * Converts this entity to a DoctorModel.
     * @return a DoctorModel with the same properties as this entity.
     */
    public DoctorModel toModel() {
        DoctorModel doctorModel = new DoctorModel();
        doctorModel.setId(this.id);
        doctorModel.setNombre(this.nombre);
        doctorModel.setApellidoPaterno(this.apellidoPaterno);
        doctorModel.setApellidoMaterno(this.apellidoMaterno);
        doctorModel.setFechaRegistro(this.fechaRegistro);
        doctorModel.setFechaModificacion(this.fechaModificacion);
        return doctorModel;
    }
}
