package projects.bootcamp.domain.api.useCase;
import org.springframework.data.domain.Pageable;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import projects.bootcamp.domain.api.ITechnologyServicePort;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ITechnologyPersistencePort;

import java.util.List;
import java.util.Optional;

public class TechnologyCase implements ITechnologyServicePort {
    private final ITechnologyPersistencePort technologyPersistencePort;
    public TechnologyCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }
    @Override
    public Optional<Technology> createTechnology(Technology technology) {
        return technologyPersistencePort.saveTechnology(technology);
    }

    @Override
    public List<Technology> getAll(Pageable pageable) {
        return technologyPersistencePort.getAll(pageable);
    }
}
