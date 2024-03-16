package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TecnologyEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TecnologyAlreadyExistExeption;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITecnologyEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITecnologyRepository;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnology;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologyPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TecnologyAdapter implements ITecnologyPersistencePort {
    private final ITecnologyRepository tecnologiaRepository ;
    private final ITecnologyEntityMapper tecnologyEntityMapper;

    @Override
    public void saveTecnology(Tecnology tecnology) {
        if (tecnologiaRepository.findByName(tecnology.getName()).isPresent()){
            throw new TecnologyAlreadyExistExeption();
        }
        tecnologiaRepository.save(tecnologyEntityMapper.toEntity(tecnology));
    }

    @Override
    public Tecnology getTecnology(String name){
        TecnologyEntity tecnology = tecnologiaRepository.findByNameContaining(name).orElseThrow(ElementNotFoundException::new);
        return tecnologyEntityMapper.toModel(tecnology);
    }

    @Override
    public List<Tecnology> getAllTecnology(Integer page, Integer size) {
        return null;
    }

    @Override
    public List<Tecnology> getAllTecnologyByCapacidad(String capacidad, Integer page, Integer size) {
        return null;
    }

    @Override
    public Tecnology updateTecnology(Tecnology tecnology) {
        return null;
    }

    @Override
    public void deleteTecnology(Long id) {

    }
}
