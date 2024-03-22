package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import com.pragma.arquetipobootcamp2024.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class TechnologyAdapter implements ITechnologyPersistencePort {
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;
    String name = "name";

    @Override
    public void saveTechnology(Technology technology) {
        if (technologyRepository.findByName(technology.getName()).isPresent()){
            throw new TechnologyAlreadyExistsException();
        }
        technologyRepository.save(technologyEntityMapper.toEntity(technology));
    }

    @Override
    public Technology getTechnology(String name){
        TechnologyEntity technology = technologyRepository.findByNameContaining(name).orElseThrow(ElementNotFoundException::new);
        return technologyEntityMapper.toModel(technology);
    }
    @Override
    public List<Technology> getAllTechnology(Integer page, Integer size, String sort) {

        Sort sortable = Sort.by(Sort.Direction.fromString(sort),name);
        Pageable pagging = PageRequest.of(page, size, sortable);
        List<TechnologyEntity> technology = technologyRepository.findAll(pagging).getContent();
        if(technology.isEmpty()){
            throw new NoDataFoundException();
        }
        return technologyEntityMapper.toModelList(technology);
    }

    @Override
    public Technology updateTechnology(Technology technology) {
        return null;
    }

    @Override
    public void deleteTechnology(Long id) {
        if (technologyRepository.findById(id).isEmpty()) {
            throw new ElementNotFoundException();
        }
        technologyRepository.deleteById(id);
    }
}
