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
    public List<Tecnology> getAllTecnologys(Integer page, Integer size, String sort) {
        return tecnologyPersistencePort.getAllTecnology(page, size, sort);
    }

    @Override
    public Tecnology updateTecnology(Tecnology tecnology) {
        return tecnologyPersistencePort.updateTecnology(tecnology);
    }

    @Override
    public void deleteTecnologia(Long id) {
        tecnologyPersistencePort.deleteTecnology(id);
    }

}
