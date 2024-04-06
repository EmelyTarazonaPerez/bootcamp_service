package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.VersionEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.IVersionEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.IVersionRepository;
import projects.bootcamp.domain.model.Version;
import projects.bootcamp.domain.spi.IVersionPersistencePort;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VersionAdapter implements IVersionPersistencePort {

    private final IVersionEntityMapper versionEntityMapper;
    private final IVersionRepository versionRepository;

    @Override
    public Version save(Version version) {
        try {
            VersionEntity result = versionRepository.save(versionEntityMapper.toVersionEntity(version));
            return versionEntityMapper.toVersion(result);
        } catch (Exception e) {
            throw new ProductAlreadyExistsException("Error");
        }
    }

    @Override
    public List<Version> getAll(int page, int size, boolean sort) {
        return null;
    }
}
