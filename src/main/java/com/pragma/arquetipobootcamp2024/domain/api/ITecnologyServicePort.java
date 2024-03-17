package com.pragma.arquetipobootcamp2024.domain.api;

import com.pragma.arquetipobootcamp2024.domain.model.Tecnology;

import java.util.List;

public interface ITecnologyServicePort {
    void saveTecnology(Tecnology tecnology);
    Tecnology getTecnology(String name);
    List<Tecnology> getAllTecnologys(Integer page, Integer size, String sort);
    Tecnology updateTecnology(Tecnology tecnology);
    void deleteTecnologia(Long id);
}
