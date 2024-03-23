package projects.bootcamp.domain.api;

import org.springframework.data.domain.Pageable;
import projects.bootcamp.domain.model.Technology;

import java.util.List;

public interface ITechnologyServicePort {
    String createTechnology(Technology technology);
    List<Technology> getAll(Pageable pageable);

}
