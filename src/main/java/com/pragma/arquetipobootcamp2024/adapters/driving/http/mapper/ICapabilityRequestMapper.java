package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddCapabilityRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.UpdateCapabilityRequest;
import com.pragma.arquetipobootcamp2024.domain.model.Capability;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICapabilityRequestMapper {
    @Mapping(target = "id", ignore = true)
    Capability addRequestToCapability(AddCapabilityRequest addCapabilityRequest);
    Capability updateRequestToCapability(UpdateCapabilityRequest updateCapabilityRequest);
}
