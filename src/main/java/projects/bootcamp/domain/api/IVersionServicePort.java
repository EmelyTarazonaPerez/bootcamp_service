package projects.bootcamp.domain.api;

import projects.bootcamp.domain.model.Version;

import java.util.List;

public interface IVersionServicePort {
    Version save(Version version);
    List<Version> getAll(int page, int size, boolean directionTechAssociated, boolean order);
}
