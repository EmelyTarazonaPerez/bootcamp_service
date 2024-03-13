package projects.bootcamp.domain.spi;

import projects.bootcamp.domain.model.Technology;

public interface ITechnologyPersistencePort {
    void  saveTechnology(Technology technology);
}
