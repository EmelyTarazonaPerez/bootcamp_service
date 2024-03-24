package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.spi.ICapacityPersistencePort;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class CapacityAdapter implements ICapacityPersistencePort {

    private ICapacityRepository capacityRepository;
    private ICapacityEntityMapper capacityEntityMapper;

    @Override
    public Capacity save(Capacity capacity) {
        if (isPresentCapacity(capacity).isPresent()) {
            throw new ProductAlreadyExistsException("Error");
        }
        CapacityEntity capacityEntity = capacityEntityMapper.toCapacityEntity(capacity);
        return capacityEntityMapper.toCapacity(capacityRepository.save(capacityEntity));
    }
    @Override
    public List<Capacity> getAll(Pageable pageable) {
        return capacityEntityMapper.toCapacityList(capacityRepository.findAll(pageable));
    }
    protected Optional<CapacityEntity> isPresentCapacity (Capacity capacity) {
        return capacityRepository.findByName(capacity.getName());
    }
}
