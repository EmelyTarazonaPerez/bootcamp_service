package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.spi.ICapacityPersistencePort;

import java.util.List;

import static projects.bootcamp.adapters.driven.jpa.mysql.utils.DataOrdering.getOrdering;
import static projects.bootcamp.adapters.driven.jpa.mysql.utils.OrderByTech.getOrderByCantTech;

@Service
@AllArgsConstructor
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
    public List<Capacity> getAll(int page, int size, boolean orderByAssociatedTech, boolean order) {
        Pageable pageable = getOrdering(page, size, order, "name");
        List<Capacity> capacities = capacityEntityMapper.toCapacityList(capacityRepository.findAll(pageable));
        if(orderByAssociatedTech){
           getOrderByCantTech(capacities, order);
        }
        return capacities;
    }

}
