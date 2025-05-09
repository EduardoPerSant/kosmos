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

import com.eduardo.prueba.kosmos.app.service.CitaService;
import com.eduardo.prueba.kosmos.app.web.model.CitaModel;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@Api(value = "CitaController")
@RestController(value = "CitaController")
@RequiredArgsConstructor
@RequestMapping("/v1/citas")
public class CitaConstroller {

    private final CitaService citaService;

    /**
     * Endpoint to create a new appointment.
     * @param cita the appointment to create.
     * @return the created appointment.
     * @throws Exception if an error occurs during the creation process.
     */
    @PostMapping
    @Validated
    public ResponseEntity<CitaModel> createCita(@RequestBody @Valid CitaModel cita) throws Exception {
        return ResponseEntity.ok().body(citaService.createCita(cita));
    }

    /**
     * Endpoint to retrieve an appointment by its ID.
     * @param id the ID of the appointment to retrieve.
     * @return the appointment with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CitaModel> getCitaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(citaService.getCitaById(id));
    }

    /**
     * Endpoint to update an existing appointment.
     * @param cita the appointment to update.
     * @return the updated appointment.
     */
    @PatchMapping("/{id}")
    @Validated
    public ResponseEntity<CitaModel> updateCita(@PathVariable("id") Long id, @RequestBody @Valid CitaModel cita) throws Exception {
        return ResponseEntity.ok().body(citaService.updateCita(id, cita));
    }

    /**
     * Endpoint to delete an appointment by its ID.
     * @param id the ID of the appointment to delete.
     * @return a response indicating the result of the deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable("id") Long id) {
        citaService.deleteCita(id);
        return ResponseEntity.noContent().build();
    }
}
