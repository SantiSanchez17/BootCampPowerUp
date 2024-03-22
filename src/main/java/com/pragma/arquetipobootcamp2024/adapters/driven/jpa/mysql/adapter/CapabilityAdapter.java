package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.CapabilityAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ICapabilityEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ICapabilityRepository;
import com.pragma.arquetipobootcamp2024.domain.model.Capability;
import com.pragma.arquetipobootcamp2024.domain.spi.ICapabilityPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CapabilityAdapter implements ICapabilityPersistencePort {
    private final ICapabilityRepository capabilityRepository;
    private final ICapabilityEntityMapper capabilityEntityMapper;

    @Override
    public void saveCapability(Capability capability) {
        if (capabilityRepository.findByName(capability.getName()).isPresent()){
            throw new CapabilityAlreadyExistsException();
        }
        capabilityRepository.save(capabilityEntityMapper.toEntity(capability));
    }

    @Override
    public Capability getCapability(String name) {
        return null;
    }

    @Override
    public Capability updateCapability(Capability capability) {
        return null;
    }

    @Override
    public void deleteCapability(Long id) {
        if (capabilityRepository.findById(id).isEmpty()){
            throw new ElementNotFoundException();
        }
        capabilityRepository.deleteById(id);
    }
}
