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
    public ResponseEntity<List<CapacityResponse>> getAll( boolean order, String nameTech,
            @RequestParam (defaultValue = "0")  int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam (defaultValue = "false")  boolean directionTechAssociated,
            @RequestParam (defaultValue = "0") int byCant) {
        return new ResponseEntity<>(capacityResponseMapper.toListCapacityResponse(
                capacityServicePort.getAll(page, size, directionTechAssociated, order, byCant, nameTech)), HttpStatus.OK);
    }
}
