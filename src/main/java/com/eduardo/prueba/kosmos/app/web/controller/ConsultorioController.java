package com.eduardo.prueba.kosmos.app.web.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.prueba.kosmos.app.service.ConsultorioService;
import com.eduardo.prueba.kosmos.app.web.model.ConsultorioModel;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;


/**
 * Controller for managing consultation rooms.
 * This controller handles requests related to consultation rooms.
 * It provides endpoints for creating, retrieving, updating, and deleting consultation rooms.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Api(value = "ConsultorioController")
@RestController(value = "ConsultorioController")
@RequiredArgsConstructor
@RequestMapping("/v1/consultorios")
public class ConsultorioController {

    private final ConsultorioService consultorioService;

    /**
     * Endpoint to create a new consultation room.
     * @param consultorio the consultation room to create.
     * @return the created consultation room.
     */
    @PostMapping
    @Validated
    public ResponseEntity<ConsultorioModel> createConsultorio(@RequestBody @Valid ConsultorioModel consultorio) {
        return ResponseEntity.ok().body(consultorioService.createConsultorio(consultorio));
    }

    /**
     * Endpoint to retrieve a consultation room by its ID.
     * @param id the ID of the consultation room to retrieve.
     * @return the consultation room with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConsultorioModel> getConsultorioById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(consultorioService.getConsultorioById(id));
    }


    /**
     * Endpoint to update an existing consultation room.
     * @param consultorio the consultation room to update.
     * @return the updated consultation room.
     */
    @PatchMapping("/{id}")
    @Validated
    public ResponseEntity<ConsultorioModel> updateConsultorio(@PathVariable("id") Long id, @RequestBody @Valid ConsultorioModel consultorio) {
        return ResponseEntity.ok().body(consultorioService.updateConsultorio(id, consultorio));
    }

    /**
     * Endpoint to delete a consultation room by its ID.
     * @param id the ID of the consultation room to delete.
     * @return a response indicating the result of the deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultorio(@PathVariable("id") Long id) {
        consultorioService.deleteConsultorio(id);
        return ResponseEntity.noContent().build();
    }
}
