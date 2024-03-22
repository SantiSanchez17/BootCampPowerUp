package com.pragma.arquetipobootcamp2024.domain.spi;

import com.pragma.arquetipobootcamp2024.domain.model.Capability;

public interface ICapabilityPersistencePort {
    void saveCapability(Capability capability);
    Capability getCapability(String name);
    Capability updateCapability(Capability capability);
    void deleteCapability(Long id);
}
