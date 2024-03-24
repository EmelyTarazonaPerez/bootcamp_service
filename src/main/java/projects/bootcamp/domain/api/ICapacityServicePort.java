package projects.bootcamp.domain.api;

import org.springframework.data.domain.Pageable;
import projects.bootcamp.domain.model.Capacity;

import java.util.List;

public interface ICapacityServicePort {
    Capacity save (Capacity capacity);
    List<Capacity> getAll (Pageable pageable, int byCant, String name);
}
