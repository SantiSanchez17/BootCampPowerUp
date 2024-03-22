package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.CapabilityEntity;
import com.pragma.arquetipobootcamp2024.domain.model.Capability;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ICapabilityEntityMapper {
    Capability toModel(CapabilityEntity capabilityEntity);
    CapabilityEntity toEntity(Capability capability);
    List<Capability> toModelList(List<CapabilityEntity> capabilityEntities);
}
