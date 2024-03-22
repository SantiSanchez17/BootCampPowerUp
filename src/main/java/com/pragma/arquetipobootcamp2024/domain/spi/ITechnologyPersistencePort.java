package com.pragma.arquetipobootcamp2024.domain.spi;

import com.pragma.arquetipobootcamp2024.domain.model.Technology;

import java.util.List;

public interface ITechnologyPersistencePort {
    void saveTechnology(Technology technology);
    Technology getTechnology(String name);
    List<Technology> getAllTechnology(Integer page, Integer size, String sort);
    Technology updateTechnology(Technology technology);
    void deleteTechnology(Long id);
}
