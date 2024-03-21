package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
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
public class TechnologyAdapter implements ITechnologyPersistencePort {

    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;
    @Override
    public Optional<Technology> saveTechnology(Technology technology) {
        try {
            TechnologyEntity technologyEntityResp = technologyRepository.save(technologyEntityMapper.toTechnologyEntity(technology));
            Technology technologyResp = technologyEntityMapper.toTechnologyModel(technologyEntityResp);
            technologyResp.setIdTechnology(technologyEntityResp.getId());
            return Optional.of(technologyResp);
        } catch (ProductAlreadyExistsException e) {
            throw new ProductAlreadyExistsException();
        }
    }

    @Override
    public List<Technology> getAll(Pageable pageable) {
        return technologyEntityMapper.toTechnologiesModel(technologyRepository.findAll(pageable));
    }


}
