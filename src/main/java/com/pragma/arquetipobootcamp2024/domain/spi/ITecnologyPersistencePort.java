package com.pragma.arquetipobootcamp2024.domain.spi;

import com.pragma.arquetipobootcamp2024.domain.model.Tecnology;

import java.util.List;

public interface ITecnologyPersistencePort {
    void saveTecnology(Tecnology tecnology);
    Tecnology getTecnology(String name);
    List<Tecnology> getAllTecnology(Integer page, Integer size, String sort);
    Tecnology updateTecnology(Tecnology tecnology);
    void deleteTecnology(Long id);
}
