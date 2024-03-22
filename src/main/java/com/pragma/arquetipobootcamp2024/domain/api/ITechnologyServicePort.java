package com.pragma.arquetipobootcamp2024.domain.api;

import com.pragma.arquetipobootcamp2024.domain.model.Technology;

import java.util.List;

public interface ITechnologyServicePort {
    void saveTechnology(Technology technology);
    Technology getTechnology(String name);
    List<Technology> getAllTechnologys(Integer page, Integer size, String sort);
    Technology updateTechnology(Technology technology);
    void deleteTechnologia(Long id);
}
