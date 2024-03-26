package projects.bootcamp.domain.api.useCase;

import projects.bootcamp.domain.api.IBootcampServicePort;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.spi.IBootcampPersistencePort;

public class BootcampCase implements IBootcampServicePort {
    private final IBootcampPersistencePort bootcampPersistencePort;
    public BootcampCase(IBootcampPersistencePort bootcampPersistencePort){
        this.bootcampPersistencePort = bootcampPersistencePort;
    }
    @Override
    public Bootcamp save(Bootcamp bootcamp) {
        return bootcampPersistencePort.save(bootcamp);
    }
}
