package projects.bootcamp.domain.api.useCase;

import projects.bootcamp.domain.api.IVersionServicePort;
import projects.bootcamp.domain.exception.ValidationErrorHandler;
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
        if (version.getEndDate().isAfter(version.getStartDate())) {
            return versionPersistencePort.save(version);
        }
        throw new ValidationErrorHandler("End date must be greater than start date");
    }

    @Override
    public List<Version> getAll(int page, int size, String orderByProperty, boolean direction, int idBootcamp) {
        List<Version> versions = versionPersistencePort.getAll(page, size, orderByProperty, direction );
        return filterByBootcamp(versions, idBootcamp);
    }

    private List<Version> filterByBootcamp (List<Version> versions, int idBootcamp) {
        if (idBootcamp == 0) return  versions;
        return versions.stream().filter(version -> version.getBootcamp().getIdBootcamp() == idBootcamp).toList();
    }
}