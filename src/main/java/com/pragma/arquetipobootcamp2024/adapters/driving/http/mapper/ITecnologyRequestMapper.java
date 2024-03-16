package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTecnologyRequest;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ITecnologyRequestMapper {
    @Mapping(target = "id", ignore = true)
    Tecnology addRequestToTecnology(AddTecnologyRequest addTecnologyRequest);
}
