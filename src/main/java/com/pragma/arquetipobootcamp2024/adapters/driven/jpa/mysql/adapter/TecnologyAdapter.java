package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TecnologyEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TecnologyAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITecnologyEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITecnologyRepository;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnology;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class TecnologyAdapter implements ITecnologyPersistencePort {
    private final ITecnologyRepository tecnologyRepository;
    private final ITecnologyEntityMapper tecnologyEntityMapper;
    String name = "name";

    @Override
    public void saveTecnology(Tecnology tecnology) {
        if (tecnologyRepository.findByName(tecnology.getName()).isPresent()){
            throw new TecnologyAlreadyExistsException();
        }
        tecnologyRepository.save(tecnologyEntityMapper.toEntity(tecnology));
    }

    @Override
    public Tecnology getTecnology(String name){
        TecnologyEntity tecnology = tecnologyRepository.findByNameContaining(name).orElseThrow(ElementNotFoundException::new);
        return tecnologyEntityMapper.toModel(tecnology);
    }
    @Override
    public List<Tecnology> getAllTecnology(Integer page, Integer size, String sort) {

        Sort sortable = Sort.by(Sort.Direction.fromString(sort),name);
        Pageable pagging = PageRequest.of(page, size, sortable);
        List<TecnologyEntity> tecnology = tecnologyRepository.findAll(pagging).getContent();
        if(tecnology.isEmpty()){
            throw new NoDataFoundException();
        }
        return tecnologyEntityMapper.toModelList(tecnology);
    }

    @Override
    public Tecnology updateTecnology(Tecnology tecnology) {
        return null;
    }

    @Override
    public void deleteTecnology(Long id) {
        if (tecnologyRepository.findById(id).isEmpty()) {
            throw new ElementNotFoundException();
        }
        tecnologyRepository.deleteById(id);
    }
}
