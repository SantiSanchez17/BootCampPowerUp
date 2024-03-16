package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TecnologyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITecnologyRepository extends JpaRepository<TecnologyEntity, Long> {
    Optional<TecnologyEntity> findByNameContaining(String name);
    Optional<TecnologyEntity> findByName(String name);
    Page<TecnologyEntity> findAll(Pageable pageable);
}
