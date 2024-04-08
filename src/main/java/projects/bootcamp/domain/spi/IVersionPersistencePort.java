package projects.bootcamp.domain.spi;

import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.model.Version;

import java.util.List;
import java.util.Optional;

public interface IVersionPersistencePort {
    Version save(Version version);
    List<Version> getAllByPagination(int page, int size, String orderByProperty, boolean direction);
    List<Version> getAll(String orderByProperty, boolean direction);
}
