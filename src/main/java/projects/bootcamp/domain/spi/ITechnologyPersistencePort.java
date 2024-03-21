package projects.bootcamp.domain.spi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projects.bootcamp.domain.model.Technology;

import java.util.List;
import java.util.Optional;

public interface ITechnologyPersistencePort {
    Optional<Technology> saveTechnology(Technology technology);
    List<Technology> getAll(Pageable pageable);

}
