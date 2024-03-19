package projects.bootcamp.domain.spi;

import projects.bootcamp.domain.model.Capacity;

import java.util.List;

public interface ICapacityPersistencePort {
    Capacity save (Capacity capacity);
    List<Capacity> getAll ();
}
