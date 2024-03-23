package projects.bootcamp.domain.spi;

import projects.bootcamp.domain.model.Capacity;

import java.util.List;
import java.util.Optional;

public interface ICapacityPersistencePort {
    Capacity save (Capacity capacity);
    List<Capacity> getAll ();
}
