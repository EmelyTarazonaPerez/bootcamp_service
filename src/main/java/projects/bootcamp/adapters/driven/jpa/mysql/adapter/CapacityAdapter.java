package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
        try {
            CapacityEntity capacityEntity = capacityEntityMapper.toCapacityEntity(capacity);
            return capacityEntityMapper.toCapacity(capacityRepository.save(capacityEntity));
        } catch (Exception e) {
            throw new ProductAlreadyExistsException("Error");
        }
    }
    @Override
    public List<Capacity> getAll(Pageable pageable) {
        return capacityEntityMapper.toCapacityList(capacityRepository.findAll(pageable));
    }

}
