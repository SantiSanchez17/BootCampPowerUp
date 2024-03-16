package com.pragma.arquetipobootcamp2024.configuration;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter.TecnologyAdapter;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITecnologyEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITecnologyRepository;
import com.pragma.arquetipobootcamp2024.domain.api.ITecnologyServicePort;
import com.pragma.arquetipobootcamp2024.domain.api.usecase.TecnologyUseCase;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ITecnologyRepository tecnologiaRepository;
    private final ITecnologyEntityMapper tecnologiaEntityMapper;
    @Bean
    public ITecnologyPersistencePort tecnologiaPersistencePort(){
        return new TecnologyAdapter(tecnologiaRepository, tecnologiaEntityMapper);
    }
    @Bean
    public ITecnologyServicePort tecnologiaServicePort(){
        return new TecnologyUseCase(tecnologiaPersistencePort());
    }

}
