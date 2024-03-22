package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.CapabilityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICapabilityRepository extends JpaRepository<CapabilityEntity, Long> {
    Optional<CapabilityEntity> findByNameContaining(String name);
    Optional<CapabilityEntity> findByName(String name);
    Page<CapabilityEntity> findAll(Pageable pageable);
}
