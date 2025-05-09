package com.eduardo.prueba.kosmos.app.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.prueba.kosmos.app.domain.entity.Doctor;

/**
 * Repository interface for managing Doctor entities.
 * This interface extends JpaRepository to provide CRUD operations for the Doctor entity.
 * @author: Eduardo Pérez
 * @date: 2025-05-09
 */
@Repository
public interface DoctorRepository  extends JpaRepository<Doctor, Long> {
    
}
