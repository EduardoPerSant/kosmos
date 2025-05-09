package com.eduardo.prueba.kosmos.app.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.eduardo.prueba.kosmos.app.web.model.ConsultorioModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a consultation room.
 * This class is mapped to the "consultorios" table in the database.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Getter
@Setter
@NoArgsConstructor
@Table(name = "consultorio")
@Entity
public class Consultorio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "piso")
    private Long piso;
    
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    /**
     * Converts this entity to a ConsultorioModel.
     * @return a ConsultorioModel with the same properties as this entity.
     */
    public ConsultorioModel toModel() {
        ConsultorioModel consultorioModel = new ConsultorioModel();
        consultorioModel.setId(this.id);
        consultorioModel.setNumero(this.numero);
        consultorioModel.setPiso(this.piso);
        consultorioModel.setFechaRegistro(this.fechaRegistro);
        consultorioModel.setFechaModificacion(this.fechaModificacion);
        return consultorioModel;
    }
}

