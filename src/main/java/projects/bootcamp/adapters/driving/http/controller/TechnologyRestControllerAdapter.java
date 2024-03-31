package projects.bootcamp.adapters.driving.http.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import projects.bootcamp.adapters.driving.http.dto.request.technology.AddTechnologyRequest;
import projects.bootcamp.adapters.driving.http.dto.response.technology.TechnologyResponse;
import projects.bootcamp.adapters.driving.http.mapper.technology.ITechnologyRequestMapper;
import projects.bootcamp.adapters.driving.http.mapper.technology.ITechnologyResponseMapper;
import projects.bootcamp.domain.api.ITechnologyServicePort;
import projects.bootcamp.domain.model.Technology;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {

    private final ITechnologyServicePort technologyPersistencePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;

    @PostMapping("/save")
    public ResponseEntity<Optional<Technology>> save (@Valid @RequestBody AddTechnologyRequest request){
        return new ResponseEntity<>( technologyPersistencePort.createTechnology(
                technologyRequestMapper.addRequestToTechnology(request)),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TechnologyResponse>> getAll (
            @RequestParam (defaultValue = "0") int page,
            @RequestParam (defaultValue = "10") int size,
            @RequestParam (defaultValue = "false") boolean sort){
        return new ResponseEntity<>(technologyResponseMapper.toListTechnologyResponse(
                technologyPersistencePort.getAll(page, size, sort)), HttpStatus.OK);
    }

}
