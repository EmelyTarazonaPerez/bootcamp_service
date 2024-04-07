package projects.bootcamp.domain.spi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projects.bootcamp.domain.model.Capacity;

import java.util.List;

public interface ICapacityPersistencePort {
    Capacity save (Capacity capacity);
    List<Capacity> getAll(int size, int page, boolean orderByAssociatedTech, boolean order);
}
