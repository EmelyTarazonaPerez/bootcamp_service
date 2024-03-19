package projects.bootcamp.domain.api.useCase;

import projects.bootcamp.domain.api.ICapacityServicePort;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.spi.ICapacityPersistencePort;

import java.util.List;

public class CapacityCase implements ICapacityServicePort {

    private final ICapacityPersistencePort capacityPersistencePort;

    public CapacityCase (ICapacityPersistencePort capacityPersistencePort){
        this.capacityPersistencePort = capacityPersistencePort;
    }

    @Override
    public Capacity save(Capacity capacity) {
        capacityPersistencePort.save(capacity);
        return null;
    }
    @Override
    public List<Capacity> getAll() {
        return null;
    }
}
