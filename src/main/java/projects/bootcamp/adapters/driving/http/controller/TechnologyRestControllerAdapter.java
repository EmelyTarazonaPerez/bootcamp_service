package projects.bootcamp.adapters.driving.http.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import projects.bootcamp.adapters.driving.http.dto.request.AddTechnologyRequest;
import projects.bootcamp.adapters.driving.http.mapper.ITechnologyRequestMapper;
import projects.bootcamp.adapters.driving.http.mapper.ITechnologyResponseMapper;
import projects.bootcamp.domain.api.ITechnologyServicePort;
import projects.bootcamp.domain.model.Technology;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {

    private final ITechnologyServicePort technologyPersistencePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;

    @PostMapping("/save")
    public ResponseEntity<Technology> technology (@Valid @RequestBody AddTechnologyRequest request){
        return new ResponseEntity<>(technologyPersistencePort.createTechnology(
                technologyRequestMapper.addRequestToTechnology(request)), HttpStatus.OK);
    }

}
