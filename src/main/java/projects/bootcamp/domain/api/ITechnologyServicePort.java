package projects.bootcamp.domain.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projects.bootcamp.domain.model.Technology;

import java.util.List;

public interface ITechnologyServicePort {
    Technology createTechnology(Technology technology);
    List<Technology> getAll(Pageable pageable);

}
