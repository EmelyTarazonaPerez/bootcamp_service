package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.spi.IBootcampPersistencePort;


@Component
@AllArgsConstructor
@RequiredArgsConstructor
public class BootcampAdapter implements IBootcampPersistencePort {
    private final IBootcampEntityMapper boorcampEntityMapper;
    private final IBootcampRepository bootcampRepository;
    @Override
    public Bootcamp save(Bootcamp bootcamp) {
        return null;
    }
}
