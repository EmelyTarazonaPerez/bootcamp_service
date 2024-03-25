package projects.bootcamp.domain.api;

import projects.bootcamp.domain.model.Bootcamp;

public interface IBootcampServicePort {
    Bootcamp save(Bootcamp bootcamp);
}
