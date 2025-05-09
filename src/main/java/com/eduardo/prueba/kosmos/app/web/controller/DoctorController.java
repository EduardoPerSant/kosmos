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

import com.eduardo.prueba.kosmos.app.service.DoctorService;
import com.eduardo.prueba.kosmos.app.web.model.DoctorModel;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

/**
 * Controller for managing doctor-related operations.
 * This controller handles requests related to doctors and their appointments.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Api(value = "DoctorController")
@RestController(value = "DoctorController")
@RequestMapping("/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    public final DoctorService doctorService;

    /**
     * Endpoint to create a new doctor.
     * @param doctor the doctor to create.
     * @return the created doctor.
     */
    @PostMapping
    @Validated
    public ResponseEntity<DoctorModel> createDoctor(@RequestBody @Valid DoctorModel doctor) {
        return ResponseEntity.ok().body(doctorService.createDoctor(doctor));
    }

    /**
     * Endpoint to retrieve a doctor by their ID.
     * @param id the ID of the doctor to retrieve.
     * @return the doctor with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DoctorModel> getDoctorById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(doctorService.getDoctorById(id));
    }

    /**
     * Endpoint to update an existing doctor.
     * @param doctor the doctor to update.
     * @return the updated doctor.
     */
    @PatchMapping("/{id}")
    @Validated
    public ResponseEntity<DoctorModel> updateDoctor(@PathVariable("id") Long id , @RequestBody @Valid DoctorModel doctor) {
        return ResponseEntity.ok().body(doctorService.updateDoctor(id, doctor));
    }

    /**
     * Endpoint to delete a doctor by their ID.
     * @param id the ID of the doctor to delete.
     * @return a response indicating the result of the deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("id") Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

}
