package projects.bootcamp.domain.api.useCase;
import org.springframework.data.domain.Pageable;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import projects.bootcamp.domain.api.ITechnologyServicePort;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ITechnologyPersistencePort;

import java.util.List;

public class TechnologyCase implements ITechnologyServicePort {
    private final ITechnologyPersistencePort technologyPersistencePort;
    public TechnologyCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }
    @Override
    public String createTechnology(Technology technology) {
        technologyPersistencePort.saveTechnology(technology);
        return "ok";
    }

    @Override
    public List<Technology> getAll(Pageable pageable) {
        return technologyPersistencePort.getAll(pageable);
    }
}
