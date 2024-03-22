package com.pragma.arquetipobootcamp2024.domain.api.usecase;

import com.pragma.arquetipobootcamp2024.domain.api.ICapabilityServicePort;
import com.pragma.arquetipobootcamp2024.domain.model.Capability;
import com.pragma.arquetipobootcamp2024.domain.spi.ICapabilityPersistencePort;

public class CapabilityUseCase implements ICapabilityServicePort {
    private final ICapabilityPersistencePort capabilityPersistencePort;
    public CapabilityUseCase(ICapabilityPersistencePort capabilityPersistencePort){
        this.capabilityPersistencePort = capabilityPersistencePort;
    }
    @Override
    public void saveCapability(Capability capability) {
        capabilityPersistencePort.saveCapability(capability);
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

    }
}
