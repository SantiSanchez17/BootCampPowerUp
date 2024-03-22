package com.pragma.arquetipobootcamp2024.domain.api;

import com.pragma.arquetipobootcamp2024.domain.model.Capability;

public interface ICapabilityServicePort {
    void saveCapability(Capability capability);
    Capability getCapability(String name);
    Capability updateCapability(Capability capability);
    void deleteCapability(Long id);
}
