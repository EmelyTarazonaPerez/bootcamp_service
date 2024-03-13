package projects.bootcamp.adapters.driving.http.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import projects.bootcamp.adapters.driving.http.dto.request.AddTechnologyRequest;
import projects.bootcamp.adapters.driving.http.mapper.ITechnologyRequestMapper;
import projects.bootcamp.adapters.driving.http.mapper.ITechnologyResponseMapper;
import projects.bootcamp.domain.spi.ITechnologyPersistencePort;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {

    private final ITechnologyPersistencePort technologyPersistencePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;

    @PostMapping("/save")
    public ResponseEntity<Void> technolog (@RequestBody AddTechnologyRequest request){
        technologyPersistencePort.saveTechnology(technologyRequestMapper.addRequestToTechnology(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
