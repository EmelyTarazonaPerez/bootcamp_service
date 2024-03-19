package projects.bootcamp.adapters.driving.http.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import projects.bootcamp.adapters.driving.http.dto.request.technology.AddTechnologyRequest;
import projects.bootcamp.adapters.driving.http.dto.response.TechnologyResponse;
import projects.bootcamp.adapters.driving.http.mapper.technology.ITechnologyRequestMapper;
import projects.bootcamp.adapters.driving.http.mapper.technology.ITechnologyResponseMapper;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ITechnologyPersistencePort;

import java.util.List;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {

    private final ITechnologyPersistencePort technologyPersistencePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;

    @PostMapping("/save")
    public ResponseEntity<TechnologyEntity> technology (@Valid @RequestBody AddTechnologyRequest request){
        return new ResponseEntity<>(technologyPersistencePort.saveTechnology(
                technologyRequestMapper.addRequestToTechnology(request)),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TechnologyResponse>> getAll (@PageableDefault(
        page=0, size = 2, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable){
        return new ResponseEntity<>(technologyResponseMapper.toListTechnologyResponse(
                technologyPersistencePort.getAll(pageable)), HttpStatus.OK);
    }

}
