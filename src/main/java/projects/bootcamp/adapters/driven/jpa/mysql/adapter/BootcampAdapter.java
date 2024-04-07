package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.spi.IBootcampPersistencePort;

import java.util.List;

import static projects.bootcamp.adapters.driven.jpa.mysql.utils.DataOrdering.getOrdering;
import static projects.bootcamp.adapters.driven.jpa.mysql.utils.OrderByTech.getOrderByCantCapacity;

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
       Pageable pageable = getOrdering(page, size, order, "name");
       List<Bootcamp> bootcamp = bootcampEntityMapper.toBootcampList(bootcampRepository.findAll(pageable));
       if(directionTechAssociated){
           getOrderByCantCapacity(bootcamp, order);
       }
       return bootcamp;
   }
}
