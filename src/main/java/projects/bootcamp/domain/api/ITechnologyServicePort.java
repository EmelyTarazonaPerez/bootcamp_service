package projects.bootcamp.domain.api;

import org.springframework.data.domain.Pageable;
import projects.bootcamp.domain.model.Technology;

import java.util.List;
import java.util.Optional;

public interface ITechnologyServicePort {
    Optional<Technology> createTechnology(Technology technology);
    List<Technology> getAll(int page, int size, boolean sort);

}
