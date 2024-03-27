package projects.bootcamp.domain.api;

import org.springframework.data.domain.Pageable;
import projects.bootcamp.domain.model.Bootcamp;


import java.util.List;

public interface IBootcampServicePort {
    Bootcamp save(Bootcamp bootcamp);
    List<Bootcamp> getAll(int page, int size, boolean directionTechAssociated, boolean order);
}
