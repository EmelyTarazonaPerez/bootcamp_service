package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import projects.bootcamp.adapters.driven.jpa.mysql.DataOrdering;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.spi.IBootcampPersistencePort;

import java.util.List;

import static projects.bootcamp.adapters.driven.jpa.mysql.DataOrdering.getOrdering;
import static projects.bootcamp.adapters.driven.jpa.mysql.OrderByTech.getOrderByCantCapacity;
import static projects.bootcamp.adapters.driven.jpa.mysql.OrderByTech.getOrderByCantTech;

@AllArgsConstructor
public class BootcampAdapter implements IBootcampPersistencePort {
    private  IBootcampRepository bootcampRepository;
    private  IBootcampEntityMapper bootcampEntityMapper;
    @Override
    public Bootcamp save(Bootcamp bootcamp) {
        return bootcampEntityMapper.toBootcamp(bootcampRepository.save(bootcampEntityMapper.toBootcampEntity(bootcamp)));
    }
    @Override
    public List<Bootcamp> getAll(int page, int size,  boolean directionTechAssociated, boolean order) {
       Pageable pageable = getOrdering(page, size, order);
       List<Bootcamp> bootcamp = bootcampEntityMapper.toBootcampList(bootcampRepository.findAll(pageable));
       if(directionTechAssociated){
           getOrderByCantCapacity(bootcamp, order);
       }
       return bootcamp;
   }
}
