package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper;


import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TecnologyEntity;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITecnologyEntityMapper {
    Tecnology toModel(TecnologyEntity tecnologyEntity);
    TecnologyEntity toEntity(Tecnology tecnology);
    List<Tecnology> toModelList(List<TecnologyEntity> tecnologyEntities);
}