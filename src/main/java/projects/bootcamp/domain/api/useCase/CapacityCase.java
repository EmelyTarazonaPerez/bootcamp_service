package projects.bootcamp.domain.api.useCase;

import projects.bootcamp.domain.api.ICapacityServicePort;
import projects.bootcamp.domain.exception.ErrorListTechnologies;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ICapacityPersistencePort;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CapacityCase implements ICapacityServicePort {

    private final ICapacityPersistencePort capacityPersistencePort;

    public CapacityCase (ICapacityPersistencePort capacityPersistencePort){
        this.capacityPersistencePort = capacityPersistencePort;
    }
    private final String ERROR_TECHNOLOGY_EQUALS = "Technologies are repeated";
    private final String ERROR_LIMIT_AND_MAX_TECH = "You must have at least 3 registered technologies and no maximum of 20";

    @Override
    public Capacity save(Capacity capacity) {
        if (validInsertNumbTechnology(capacity)){
            throw new ErrorListTechnologies(ERROR_LIMIT_AND_MAX_TECH);
        }
        Set<Technology> technologySet = convertirListToSet(capacity);

        if (thereTechnologyEquals(capacity.getTechnologyList(), technologySet)){
            throw new ErrorListTechnologies(ERROR_TECHNOLOGY_EQUALS);
        }
        return capacityPersistencePort.save(capacity);
    }
    @Override
    public List<Capacity> getAll() {
        return null;
    }

    protected boolean validInsertNumbTechnology (Capacity capacity) {
        return capacity.getTechnologyList().size() < 3 || capacity.getTechnologyList().size() > 20;
    }
    protected Set<Technology> convertirListToSet (Capacity capacity) {
        List<Technology> listTechnology = capacity.getTechnologyList();
        return new HashSet<>(listTechnology);
    }
    protected boolean thereTechnologyEquals (List<Technology> technologiesList , Set<Technology> technologieSet ) {
        return technologieSet.size() < technologiesList.size();
    }
}
