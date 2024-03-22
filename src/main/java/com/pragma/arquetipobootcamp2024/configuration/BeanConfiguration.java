package com.pragma.arquetipobootcamp2024.configuration;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter.CapabilityAdapter;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ICapabilityEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ICapabilityRepository;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.arquetipobootcamp2024.domain.api.ICapabilityServicePort;
import com.pragma.arquetipobootcamp2024.domain.api.ITechnologyServicePort;
import com.pragma.arquetipobootcamp2024.domain.api.usecase.CapabilityUseCase;
import com.pragma.arquetipobootcamp2024.domain.api.usecase.TechnologyUseCase;
import com.pragma.arquetipobootcamp2024.domain.spi.ICapabilityPersistencePort;
import com.pragma.arquetipobootcamp2024.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ITechnologyRepository technologiaRepository;
    private final ITechnologyEntityMapper technologiaEntityMapper;
    private final ICapabilityRepository capabilityRepository;
    private final ICapabilityEntityMapper capabilityEntityMapper;
    @Bean
    public ITechnologyPersistencePort technologiaPersistencePort(){
        return new TechnologyAdapter(technologiaRepository, technologiaEntityMapper);
    }
    @Bean
    public ITechnologyServicePort technologiaServicePort(){
        return new TechnologyUseCase(technologiaPersistencePort());
    }

    @Bean
    public ICapabilityPersistencePort capabilityPersistencePort(){
        return new CapabilityAdapter(capabilityRepository, capabilityEntityMapper);
    }

    @Bean
    public ICapabilityServicePort capabilityServicePort(){
        return new CapabilityUseCase(capabilityPersistencePort());
    }

}
