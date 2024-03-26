package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.spi.IBootcampPersistencePort;

@AllArgsConstructor
public class BootcampAdapter implements IBootcampPersistencePort {
    private  IBootcampRepository bootcampRepository;
    private  IBootcampEntityMapper boorcampEntityMapper;
    @Override
    public Bootcamp save(Bootcamp bootcamp) {
        return boorcampEntityMapper.toBootcamp(bootcampRepository.save(boorcampEntityMapper.toBootcampEntity(bootcamp)));
    }
}
