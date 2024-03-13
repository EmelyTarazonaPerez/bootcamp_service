package projects.bootcamp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import projects.bootcamp.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import projects.bootcamp.domain.api.ITechnologyServicePort;
import projects.bootcamp.domain.api.useCase.TechonologyCase;
import projects.bootcamp.domain.spi.ITechnologyPersistencePort;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;
    @Bean
    public ITechnologyPersistencePort technologyPersistencePort(){
        return new TechnologyAdapter(technologyRepository, technologyEntityMapper);
    }
    @Bean
    public ITechnologyServicePort technologyServicePort(){
        return new TechonologyCase(technologyPersistencePort());
    }
}
