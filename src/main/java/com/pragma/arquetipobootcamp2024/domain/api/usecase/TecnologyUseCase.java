package com.pragma.arquetipobootcamp2024.domain.api.usecase;

import com.pragma.arquetipobootcamp2024.domain.api.ITecnologyServicePort;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnology;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologyPersistencePort;

import java.util.List;

public class TecnologyUseCase implements ITecnologyServicePort {
    private ITecnologyPersistencePort tecnologyPersistencePort;

    public TecnologyUseCase(ITecnologyPersistencePort tecnologiaPersistencePort){
        this.tecnologyPersistencePort = tecnologiaPersistencePort;
    }

    @Override
    public void saveTecnology(Tecnology tecnology) {
        tecnologyPersistencePort.saveTecnology(tecnology);
    }

    @Override
    public Tecnology getTecnology(String name){
        return tecnologyPersistencePort.getTecnology(name);
    }

    @Override
    public List<Tecnology> getAllTecnologias(Integer page, Integer size) {
        return null;
    }

    @Override
    public List<Tecnology> getAllTecnologiasByCapacidad(String capacidad, Integer page, Integer size) {
        return null;
    }

    @Override
    public Tecnology updateTecnologia(Tecnology tecnology) {
        return null;
    }

    @Override
    public void deleteTecnologia(Long id) {

    }

}
