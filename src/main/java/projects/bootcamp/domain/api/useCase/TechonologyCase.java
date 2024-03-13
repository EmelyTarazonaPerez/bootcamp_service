package projects.bootcamp.domain.api.useCase;
import projects.bootcamp.domain.api.ITechnologyServicePort;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ITechnologyPersistencePort;

public class TechonologyCase implements ITechnologyServicePort {
    private final ITechnologyPersistencePort technologyPersistencePort;
    public TechonologyCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }
    @Override
    public void createTechnology(Technology technology) {
       technologyPersistencePort.saveTechnology(technology);
    }
}
