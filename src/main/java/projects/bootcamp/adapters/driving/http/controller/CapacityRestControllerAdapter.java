package projects.bootcamp.adapters.driving.http.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.bootcamp.adapters.driving.http.dto.request.capacity.AddCapacityRequest;
import projects.bootcamp.adapters.driving.http.mapper.capacity.ICapacityRequestMapper;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.spi.ICapacityPersistencePort;

@RestController
@RequestMapping("/capacity")
@RequiredArgsConstructor
public class CapacityRestControllerAdapter {
    private final ICapacityPersistencePort capacityPersistencePort;
    private final ICapacityRequestMapper capacityRequestMapper;

    @PostMapping("/save")
    public ResponseEntity<Capacity> capacity ( @Valid @RequestBody AddCapacityRequest request){
        return new ResponseEntity<>(capacityPersistencePort.save(
                capacityRequestMapper.addRequestToCapacity(request)), HttpStatus.OK);
    }
}
