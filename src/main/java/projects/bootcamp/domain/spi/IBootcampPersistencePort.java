package projects.bootcamp.domain.spi;

import projects.bootcamp.domain.model.Bootcamp;

public interface IBootcampPersistencePort {
    Bootcamp save(Bootcamp bootcamp);
}
