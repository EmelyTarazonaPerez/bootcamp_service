package projects.bootcamp.domain.spi;

import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.model.Version;

import java.util.List;
import java.util.Optional;

public interface IVersionPersistencePort {
    Optional<Version> save(Version version);
    List<Version> getAll(int page, int size, boolean sort);
}
