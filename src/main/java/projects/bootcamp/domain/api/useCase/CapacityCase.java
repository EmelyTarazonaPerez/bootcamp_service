package projects.bootcamp.domain.api.useCase;

import org.springframework.data.domain.Pageable;
import projects.bootcamp.domain.api.ICapacityServicePort;
import projects.bootcamp.domain.exception.ErrorListTechnologies;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ICapacityPersistencePort;
import java.util.*;
import java.util.stream.Collectors;

public class CapacityCase implements ICapacityServicePort {
    private final ICapacityPersistencePort capacityPersistencePort;
    public CapacityCase (ICapacityPersistencePort capacityPersistencePort){
        this.capacityPersistencePort = capacityPersistencePort;
    }

    @Override
    public Capacity save(Capacity capacity) {
        Set<Technology> technologySet = convertirListToSet(capacity);
        if (thereTechnologyEquals(capacity.getTechnologyList(), technologySet)){
            String messageError = "Technologies are repeated";
            throw new ErrorListTechnologies(messageError);
        }
        return capacityPersistencePort.save(capacity);
    }

    @Override
    public List<Capacity> getAll(int size, int page, boolean directionTechAssociated, boolean order, int byCant, String name) {
        List<Capacity> capacityList = capacityPersistencePort.getAll(size, page , directionTechAssociated, order);
        return techAssociated(capacityList, name, byCant);
    }

    private List<Capacity> filterByTech (List<Capacity> capacityList, int byCant) {
        return capacityList.stream().filter(capacity ->  {
            if (byCant == 0) return true;
            else return capacity.getTechnologyList().size() == byCant;
        } ).toList();
    }
    private List<Capacity> techAssociated (List<Capacity> capacityList, String name, int byCant) {
        if (name == null) return filterByTech(capacityList, byCant);
        return filterByTech(capacityList, byCant).stream()
                .filter(capacity -> capacity.getTechnologyList().stream()
                        .anyMatch(technology -> technology.getName().equals(name))).toList();
    }
    private Set<Technology> convertirListToSet (Capacity capacity) {
        List<Technology> listTechnology = capacity.getTechnologyList();
        return new HashSet<>(listTechnology);
    }
    private boolean thereTechnologyEquals (List<Technology> technologiesList , Set<Technology> technologieSet ) {
        return technologieSet.size() < technologiesList.size();
    }
}
