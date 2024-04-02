package projects.bootcamp.domain.api.useCase;

import projects.bootcamp.domain.api.IVersionServicePort;
import projects.bootcamp.domain.model.Version;
import projects.bootcamp.domain.spi.IVersionPersistencePort;

import java.util.List;

public class VersionCase implements IVersionServicePort {

    private final IVersionPersistencePort versionPersistencePort;

    public VersionCase(IVersionPersistencePort versionPersistencePort) {
        this.versionPersistencePort = versionPersistencePort;
    }
    @Override
    public Version save(Version version) {
        versionPersistencePort.save(version);
        return null;
    }

    @Override
    public List<Version> getAll(int page, int size, boolean directionTechAssociated, boolean order) {
        return null;
    }
}
