package projects.bootcamp.domain.api.useCase;

import projects.bootcamp.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import projects.bootcamp.domain.api.ICapacityServicePort;
import projects.bootcamp.domain.exception.ErrorListTechnologies;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ICapacityPersistencePort;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CapacityCase implements ICapacityServicePort {

    private final ICapacityPersistencePort capacityPersistencePort;

    public CapacityCase (ICapacityPersistencePort capacityPersistencePort){
        this.capacityPersistencePort = capacityPersistencePort;
    }

    @Override
    public Capacity save(Capacity capacity) {
        if (capacity.getTechnologyList().size() < 3 || capacity.getTechnologyList().size()  > 20){
            System.out.println("Se debe tener almenos 3 tecnologias registradas y no maximo de 20");
        }
        List<Technology> conjunto = capacity.getTechnologyList();
        Set<Technology> set = new HashSet<>(conjunto);

        if (set.size() < conjunto.size()){
            System.out.println("Las technologias son repetidas");
        }
        return capacityPersistencePort.save(capacity);
    }
    @Override
    public List<Capacity> getAll() {
        return null;
    }
}
