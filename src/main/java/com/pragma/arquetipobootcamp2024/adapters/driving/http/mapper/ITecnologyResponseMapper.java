package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.TecnologyResponse;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnology;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITecnologyResponseMapper {
    TecnologyResponse toTecnologyResponse(Tecnology tecnology);
    List<TecnologyResponse> toTecnologyResponseList(List<Tecnology> tecnology);
}
