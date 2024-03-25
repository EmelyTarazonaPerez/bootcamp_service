package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.IBoorcampEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;


@Component
@AllArgsConstructor
@RequiredArgsConstructor
public class BootcampAdapter {
    private IBoorcampEntityMapper boorcampEntityMapper;
    private IBootcampRepository bootcampRepository;
}
