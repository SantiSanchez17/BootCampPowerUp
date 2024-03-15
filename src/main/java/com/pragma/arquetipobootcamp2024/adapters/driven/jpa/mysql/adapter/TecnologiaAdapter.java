package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TecnologiaEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TecnologiaAlreadyExistExeption;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITecnologiaEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITecnologiaRepository;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologiaPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TecnologiaAdapter implements ITecnologiaPersistencePort {
    private final ITecnologiaRepository tecnologiaRepository ;
    private final ITecnologiaEntityMapper tecnologiaEntityMapper;

    @Override
    public void saveTecnologia(Tecnologia tecnologia) {
        if (tecnologiaRepository.findByName(tecnologia.getName()).isPresent()){
            throw new TecnologiaAlreadyExistExeption();
        }
        tecnologiaRepository.save(tecnologiaEntityMapper.toEntity(tecnologia));
    }

    @Override
    public Tecnologia getTecnologia(String name){
        TecnologiaEntity tecnologia = tecnologiaRepository.findByNameContaining(name).orElseThrow(ElementNotFoundException::new);
        return tecnologiaEntityMapper.toModel(tecnologia);
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
