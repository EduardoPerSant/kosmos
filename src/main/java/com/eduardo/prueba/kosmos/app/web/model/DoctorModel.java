package com.eduardo.prueba.kosmos.app.web.model;

import java.time.LocalDateTime;

import com.eduardo.prueba.kosmos.app.domain.entity.Doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model class representing a doctor.
 * This class is used for API responses and requests.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "DoctorModel", description = "Model representing a doctor.")
public class DoctorModel {

    @ApiModelProperty(value = "ID of the doctor", example = "1", required = false)
    private Long id;

    @ApiModelProperty(value = "Name of the doctor", example = "Eduardo", required = true)
    private String nombre;

    @ApiModelProperty(value = "Last name of the doctor", example = "Pérez", required = true)
    private String apellidoPaterno;

    @ApiModelProperty(value = "Mother's last name of the doctor", example = "González", required = true)
    private String apellidoMaterno;

    @ApiModelProperty(value = "Date of registration", example = "2025-05-09", required = false)
    private LocalDateTime fechaRegistro;

    @ApiModelProperty(value = "Date of modification", example = "2025-05-09", required = false)
    private LocalDateTime fechaModificacion;

    /**
     * Converts this model to a Doctor entity.
     * @return a Doctor entity with the same properties as this model.
     */
    public Doctor toEntity() {
        Doctor doctor = new Doctor();
        doctor.setId(this.id);
        doctor.setNombre(this.nombre);
        doctor.setApellidoPaterno(this.apellidoPaterno);
        doctor.setApellidoMaterno(this.apellidoMaterno);
        doctor.setFechaRegistro(this.fechaRegistro);
        doctor.setFechaModificacion(this.fechaModificacion);
        return doctor;
    }
    
}
