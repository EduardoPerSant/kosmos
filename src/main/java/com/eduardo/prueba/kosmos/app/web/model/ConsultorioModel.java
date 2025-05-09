package com.eduardo.prueba.kosmos.app.web.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.eduardo.prueba.kosmos.app.domain.entity.Consultorio;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model class representing a consultation room.
 * This class is used for API responses and requests.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "ConsultorioModel", description = "Model representing a consultation room.")
public class ConsultorioModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID of the consultation room", example = "1", required = false)
    private Long id;

    @ApiModelProperty(value = "Number of the consultation room", example = "101", required = true)
    private String numero;

    @ApiModelProperty(value = "Floor of the consultation room", example = "1", required = true)
    private Long piso;
    
    @ApiModelProperty(value = "Date of registration", example = "2025-05-09", required = false)
    private LocalDateTime fechaRegistro;

    @ApiModelProperty(value = "Date of modification", example = "2025-05-09", required = false)
    private LocalDateTime fechaModificacion;

    /**
     * Converts this model to a Consultorio entity.
     * @return a Consultorio entity with the same properties as this model.
     */
    public Consultorio toEntity() {
        Consultorio consultorio = new Consultorio();
        consultorio.setId(this.id);
        consultorio.setNumero(this.numero);
        consultorio.setPiso(this.piso);
        consultorio.setFechaRegistro(this.fechaRegistro);
        consultorio.setFechaModificacion(this.fechaModificacion);
        return consultorio;
    }

}
