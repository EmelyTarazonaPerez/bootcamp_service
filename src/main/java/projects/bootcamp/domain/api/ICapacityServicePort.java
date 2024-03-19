package projects.bootcamp.domain.api;

import projects.bootcamp.domain.model.Capacity;

import java.util.List;

public interface ICapacityServicePort {
    Capacity save (Capacity capacity);
    List<Capacity> getAll ();
}
