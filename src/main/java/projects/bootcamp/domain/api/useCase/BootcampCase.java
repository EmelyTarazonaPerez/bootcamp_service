package projects.bootcamp.domain.api.useCase;

import org.springframework.data.domain.Pageable;
import projects.bootcamp.domain.api.IBootcampServicePort;
import projects.bootcamp.domain.exception.ErrorListTechnologies;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.spi.IBootcampPersistencePort;

import java.util.List;

public class BootcampCase implements IBootcampServicePort {
    private final IBootcampPersistencePort bootcampPersistencePort;
    public BootcampCase(IBootcampPersistencePort bootcampPersistencePort){
        this.bootcampPersistencePort = bootcampPersistencePort;
    }
    @Override
    public Bootcamp save(Bootcamp bootcamp) {
       if (validInsertNumbAssociated(bootcamp.getCapacityList().size(), 1, 4)) {
            throw new ErrorListTechnologies("numero de capacidades debe ser mayor a uno y menor a 4");
       }
        return bootcampPersistencePort.save(bootcamp);
    }

    @Override
    public List<Bootcamp> getAll(int size, int page, boolean directionTechAssociated, boolean order) {
        return  bootcampPersistencePort.getAll(size, page, directionTechAssociated, order);
    }
    public boolean validInsertNumbAssociated (int size, int min, int max) {
        return size < min || size > max;
    }
}
