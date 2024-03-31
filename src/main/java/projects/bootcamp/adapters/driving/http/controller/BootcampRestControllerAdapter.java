package projects.bootcamp.adapters.driving.http.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import projects.bootcamp.adapters.driving.http.dto.request.bootcamp.AddBootcampRequest;
import projects.bootcamp.adapters.driving.http.dto.request.capacity.AddCapacityRequest;
import projects.bootcamp.adapters.driving.http.dto.response.bootcamp.BootcampResponse;
import projects.bootcamp.adapters.driving.http.mapper.bootcamp.IBootcampMapperRequest;
import projects.bootcamp.adapters.driving.http.mapper.bootcamp.IBootcampMapperRespons;
import projects.bootcamp.domain.api.IBootcampServicePort;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.model.Capacity;

import java.util.List;

@RestController
@RequestMapping("/bootcamp")
@RequiredArgsConstructor
public class BootcampRestControllerAdapter {
    private final IBootcampServicePort bootcampServicePort;
    private final IBootcampMapperRequest bootcampMapperRequest;
    private final IBootcampMapperRespons bootcampMapperRespons;

    @PostMapping("/save")
    public ResponseEntity<Bootcamp> save(@Valid @RequestBody AddBootcampRequest request) {
        return new ResponseEntity<>(bootcampServicePort.save(
                bootcampMapperRequest.toBootcamp(request)), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<BootcampResponse>> getAll(
            @RequestParam(defaultValue = "false") boolean order,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "false") boolean directionTechAssociated) {
        return new ResponseEntity<>(bootcampMapperRespons.toBootcampResponseList(bootcampServicePort.getAll(page, size, directionTechAssociated, order)), HttpStatus.OK);
    }
}
