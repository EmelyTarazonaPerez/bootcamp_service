package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ITechnologyPersistencePort;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class TechnologyAdapter implements ITechnologyPersistencePort {

    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Override
    public Optional<Technology> saveTechnology(Technology technology) {
        if (isPresentTechnology(technology).isPresent()){
            throw new ProductAlreadyExistsException("producto repetido");
        }

        TechnologyEntity technologyEntityResp = technologyRepository.save(technologyEntityMapper.toTechnologyEntity(technology));
        Technology technologyResp = technologyEntityMapper.toTechnologyModel(technologyEntityResp);
        return Optional.of(technologyResp);
    }

    @Override
    public List<Technology> getAll(Pageable pageable) {
        return technologyEntityMapper.toTechnologiesModel(technologyRepository.findAll(pageable));
    }

    protected Optional<TechnologyEntity> isPresentTechnology (Technology technology) {
        return technologyRepository.findByName(technology.getName());
    }
}
