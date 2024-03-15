package com.pragma.arquetipobootcamp2024.domain.api.usecase;

import com.pragma.arquetipobootcamp2024.domain.api.ITecnologiaServicePort;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologiaPersistencePort;

import java.util.List;

public class TecnologiaUseCase implements ITecnologiaServicePort{
    private ITecnologiaPersistencePort tecnologiaPersistencePort;

    public TecnologiaUseCase(ITecnologiaPersistencePort tecnologiaPersistencePort){
        this.tecnologiaPersistencePort = tecnologiaPersistencePort;
    }

    @Override
    public void saveTecnologia(Tecnologia tecnologia) {
        tecnologiaPersistencePort.saveTecnologia(tecnologia);
    }

    @Override
    public Tecnologia getTecnologia(String name){
        return tecnologiaPersistencePort.getTecnologia(name);
    }

    @Override
    public List<Tecnologia> getAllTecnologias(Integer page, Integer size) {
        return null;
    }

    @Override
    public List<Tecnologia> getAllTecnologiasByCapacidad(String capacidad, Integer page, Integer size) {
        return null;
    }

    @Override
    public Tecnologia updateTecnologia(Tecnologia tecnologia) {
        return null;
    }

    @Override
    public void deleteTecnologia(Long id) {

    }
}
