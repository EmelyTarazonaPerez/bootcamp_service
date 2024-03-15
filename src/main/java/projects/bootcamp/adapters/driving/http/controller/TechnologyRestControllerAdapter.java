package projects.bootcamp.adapters.driving.http.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import projects.bootcamp.adapters.driving.http.dto.request.AddTechnologyRequest;
import projects.bootcamp.adapters.driving.http.dto.response.TechnologyResponse;
import projects.bootcamp.adapters.driving.http.mapper.ITechnologyRequestMapper;
import projects.bootcamp.adapters.driving.http.mapper.ITechnologyResponseMapper;
import projects.bootcamp.domain.spi.ITechnologyPersistencePort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {

    private final ITechnologyPersistencePort technologyPersistencePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;

    @PostMapping("/save")
    public ResponseEntity<Void> technology (@Valid @RequestBody AddTechnologyRequest request){
        technologyPersistencePort.saveTechnology(technologyRequestMapper.addRequestToTechnology(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("")
    public ResponseEntity<List<TechnologyResponse>> getAll (@PageableDefault(
            page=0, size = 2, sort = Sort.by(Sort.Direction.ASC, "name")) Pageable pageable){
        return new ResponseEntity<>(technologyResponseMapper.toListTechnologyResponse(
                technologyPersistencePort.getAll(pageable)), HttpStatus.OK);
    }

}
