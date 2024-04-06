package projects.bootcamp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import projects.bootcamp.adapters.driven.jpa.mysql.adapter.BootcampAdapter;
import projects.bootcamp.adapters.driven.jpa.mysql.adapter.CapacityAdapter;
import projects.bootcamp.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import projects.bootcamp.adapters.driven.jpa.mysql.adapter.VersionAdapter;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.IVersionEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.IVersionRepository;
import projects.bootcamp.domain.api.IBootcampServicePort;
import projects.bootcamp.domain.api.ICapacityServicePort;
import projects.bootcamp.domain.api.ITechnologyServicePort;
import projects.bootcamp.domain.api.IVersionServicePort;
import projects.bootcamp.domain.api.useCase.BootcampCase;
import projects.bootcamp.domain.api.useCase.CapacityCase;
import projects.bootcamp.domain.api.useCase.TechnologyCase;
import projects.bootcamp.domain.api.useCase.VersionCase;
import projects.bootcamp.domain.spi.IBootcampPersistencePort;
import projects.bootcamp.domain.spi.ICapacityPersistencePort;
import projects.bootcamp.domain.spi.ITechnologyPersistencePort;
import projects.bootcamp.domain.spi.IVersionPersistencePort;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    private final ICapacityRepository capacityRepository;
    private final ICapacityEntityMapper capacityEntityMapper;

    private final IBootcampEntityMapper bootcampEntityMapper;
    private final IBootcampRepository bootcampRepository;

    private final IVersionEntityMapper versionEntityMapper;
    private final IVersionRepository versionRepository;

    @Bean
    public ITechnologyPersistencePort technologyPersistencePort(){
        return new TechnologyAdapter(technologyRepository, technologyEntityMapper);
    }
    @Bean
    public ITechnologyServicePort technologyServicePort(){
        return new TechnologyCase(technologyPersistencePort());
    }
    @Bean
    public ICapacityPersistencePort capacityPersistencePort () {
        return new CapacityAdapter(capacityRepository, capacityEntityMapper);
    }
    @Bean
    public ICapacityServicePort capacityServicePort () {
        return new CapacityCase(capacityPersistencePort());
    }

    @Bean
    public IBootcampPersistencePort bootcampPersistencePort () {
        return new BootcampAdapter(bootcampRepository, bootcampEntityMapper);
    }
    @Bean
    public IBootcampServicePort bootcampServicePort () {
        return  new BootcampCase(bootcampPersistencePort());
    }

    @Bean
    public IVersionPersistencePort versionPersistencePort(){
        return new VersionAdapter(versionEntityMapper,versionRepository);
    }
    @Bean
    public IVersionServicePort versionServicePort(){
        return new VersionCase(versionPersistencePort());
    }

}
