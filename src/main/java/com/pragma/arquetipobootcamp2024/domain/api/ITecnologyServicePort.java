package com.pragma.arquetipobootcamp2024.domain.api;

import com.pragma.arquetipobootcamp2024.domain.model.Tecnology;

import java.util.List;

public interface ITecnologyServicePort {
    void saveTecnology(Tecnology tecnology);
    Tecnology getTecnology(String name);
    List<Tecnology> getAllTecnologias(Integer page, Integer size);
    List<Tecnology> getAllTecnologiasByCapacidad(String capacidad, Integer page, Integer size);
    Tecnology updateTecnologia(Tecnology tecnology);
    void deleteTecnologia(Long id);
}
