package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ITechnologyPersistencePort;

@Service
@AllArgsConstructor
public class TechnologyAdapter implements ITechnologyPersistencePort {

    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;
    @Override
    public void saveTechnology(Technology technology) {
        technologyRepository.save(technologyEntityMapper.toTechnologyEntity(technology));
    }
}
