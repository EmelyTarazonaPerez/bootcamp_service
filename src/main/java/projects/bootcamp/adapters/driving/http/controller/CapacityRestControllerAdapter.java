package projects.bootcamp.adapters.driving.http.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projects.bootcamp.adapters.driving.http.dto.request.capacity.AddCapacityRequest;
import projects.bootcamp.adapters.driving.http.dto.response.capacity.CapacityResponse;
import projects.bootcamp.adapters.driving.http.mapper.capacity.ICapacityRequestMapper;
import projects.bootcamp.adapters.driving.http.mapper.capacity.ICapacityResponsMapper;
import projects.bootcamp.domain.api.ICapacityServicePort;
import projects.bootcamp.domain.model.Capacity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/capacity")
@RequiredArgsConstructor
public class CapacityRestControllerAdapter {
    private final ICapacityServicePort capacityServicePort;
    private final ICapacityRequestMapper capacityRequestMapper;
    private final ICapacityResponsMapper capacityResponseMapper;


    @PostMapping("/save")
    public ResponseEntity<Capacity> capacity (@Valid @RequestBody AddCapacityRequest request){
        return new ResponseEntity<>(capacityServicePort.save(
                capacityRequestMapper.addRequestToCapacity(request)), HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<CapacityResponse>> getAll( @PageableDefault( page=0,
            size = 2, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable, @RequestParam int byCant ) {
        return new ResponseEntity<>(capacityResponseMapper.toListCapacityResponse(
                capacityServicePort.getAll(pageable, byCant)), HttpStatus.OK);
    }
}
