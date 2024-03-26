package projects.bootcamp.adapters.driving.http.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import projects.bootcamp.adapters.driving.http.dto.request.bootcamp.AddBootcampRequest;
import projects.bootcamp.adapters.driving.http.dto.request.capacity.AddCapacityRequest;
import projects.bootcamp.adapters.driving.http.mapper.bootcamp.IBootcampMapperRequest;
import projects.bootcamp.domain.api.IBootcampServicePort;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.model.Capacity;

@RestController
@RequestMapping("/bootcamp")
@RequiredArgsConstructor
public class BootcampRestControllerAdapter {
    private final IBootcampServicePort bootcampServicePort;
    private final IBootcampMapperRequest bootcampMapperRequest;
    @PostMapping("/save")
    public ResponseEntity<Bootcamp> save (@Valid @RequestBody AddBootcampRequest request){
        return new ResponseEntity<>(bootcampServicePort.save(
                bootcampMapperRequest.toBootcamp(request)), HttpStatus.OK);
    }
}
