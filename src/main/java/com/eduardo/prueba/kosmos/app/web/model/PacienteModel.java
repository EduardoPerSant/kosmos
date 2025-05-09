package com.eduardo.prueba.kosmos.app.web.model;

import java.io.Serializable;
import java.time.LocalDateTime;


import com.eduardo.prueba.kosmos.app.domain.entity.Paciente;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model class representing a patient.
 * This class is used for API responses and requests.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "PacienteModel", description = "Model representing a patient.")
public class PacienteModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID of the patient", example = "1", required = false)
    private Long id;

    @ApiModelProperty(value = "Name of the patient", example = "Eduardo", required = true)
    private String nombre;

    @ApiModelProperty(value = "Last name of the patient", example = "Pérez", required = true)
    private String apellidoPaterno;
    
    @ApiModelProperty(value = "Mother's last name of the patient", example = "González", required = true)
    private String apellidoMaterno;

    @ApiModelProperty(value = "Date of registration", example = "2025-05-09", required = false)
    private LocalDateTime fechaRegistro;

    @ApiModelProperty(value = "Date of modification", example = "2025-05-09", required = false)
    private LocalDateTime fechaModificacion;


    /**
     * Converts this model to a Paciente entity.
     * @return a Paciente entity with the same properties as this model.
     */
    public Paciente toEntity() {
        Paciente paciente = new Paciente();
        paciente.setId(this.id);
        paciente.setNombre(this.nombre);
        paciente.setApellidoPaterno(this.apellidoPaterno);
        paciente.setApellidoMaterno(this.apellidoMaterno);
        paciente.setFechaRegistro(this.fechaRegistro);
        paciente.setFechaModificacion(this.fechaModificacion);
        return paciente;
    }
}
