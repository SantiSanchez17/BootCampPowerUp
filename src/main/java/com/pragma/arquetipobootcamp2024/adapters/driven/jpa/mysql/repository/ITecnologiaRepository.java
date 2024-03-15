package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TecnologiaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITecnologiaRepository extends JpaRepository<TecnologiaEntity, Long> {
    Optional<TecnologiaEntity> findByNameContaining(String name);
    Optional<TecnologiaEntity> findByName(String name);
    Page<TecnologiaEntity> findAll(Pageable pageable);
    Page<TecnologiaEntity> findAllByCapacidadNameContaining(String capacidad, Pageable pageable);
}
