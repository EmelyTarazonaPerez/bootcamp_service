package projects.bootcamp.adapters.driving.http.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projects.bootcamp.adapters.driving.http.dto.request.version.AddVersionRequest;
import projects.bootcamp.adapters.driving.http.dto.response.version.VersionResponse;
import projects.bootcamp.adapters.driving.http.mapper.version.IVersionRequestMapper;
import projects.bootcamp.adapters.driving.http.mapper.version.IVersionResponsMapper;
import projects.bootcamp.domain.api.IVersionServicePort;

import java.util.List;


@RestController
@RequestMapping("/version")
@RequiredArgsConstructor
public class VersionRestControllerAdapter {
    private final IVersionServicePort versionServicePort;
    private final IVersionRequestMapper versionRequestMapper;
    private final IVersionResponsMapper versionResponseMapper;

    @PostMapping("/save")
    public ResponseEntity<VersionResponse> save (@Valid @RequestBody AddVersionRequest request){
        VersionResponse response = versionResponseMapper.toVersionResponse(versionServicePort.save(
                versionRequestMapper.toVersion(request)));
        return new ResponseEntity<>( response , HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<VersionResponse>> getAll (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam (defaultValue = "10") int size,
            //order
            @RequestParam(defaultValue = "version") String orderByProperty,
            //direction ASC o DESC
            @RequestParam(defaultValue = "false") boolean direction,
            //filter by bootcamp
            @RequestParam(defaultValue = "0") int idBootcamp

    ){
        return new ResponseEntity<>(versionResponseMapper.toListVersionResponse(
                versionServicePort.getAll(page, size, orderByProperty, direction, idBootcamp)), HttpStatus.OK );
    }
}
