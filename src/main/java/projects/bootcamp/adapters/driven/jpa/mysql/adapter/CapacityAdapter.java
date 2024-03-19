package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ICapacityPersistencePort;

import java.util.List;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class CapacityAdapter implements ICapacityPersistencePort {

    private ICapacityRepository capacityRepository;
    private ICapacityEntityMapper capacityEntityMapper;

    @Override
    public Capacity save(Capacity capacity) {
        CapacityEntity capacityEntity = capacityEntityMapper.toCapacityEntity(capacity);
        capacityRepository.save(capacityEntity);
        return capacity;
    }
    @Override
    public List<Capacity> getAll() {
        return null;
    }
    protected Boolean isPresentCapacity (Capacity capacity) {
        return capacityRepository.findByName(capacity.getName()).isPresent();
    }
}
