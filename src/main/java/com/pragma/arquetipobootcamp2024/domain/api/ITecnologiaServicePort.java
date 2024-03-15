package com.pragma.arquetipobootcamp2024.domain.api;

import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;

import java.util.List;

public interface ITecnologiaServicePort {
    void saveTecnologia(Tecnologia tecnologia);
    Tecnologia getTecnologia(String name);
    List<Tecnologia> getAllTecnologias(Integer page, Integer size);
    List<Tecnologia> getAllTecnologiasByCapacidad(String capacidad,Integer page, Integer size);
    Tecnologia updateTecnologia(Tecnologia tecnologia);
    void deleteTecnologia(Long id);
}
