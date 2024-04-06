package projects.bootcamp.adapters.driving.http.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.bootcamp.adapters.driving.http.dto.request.version.AddVersionRequest;
import projects.bootcamp.adapters.driving.http.dto.response.version.VersionResponse;
import projects.bootcamp.adapters.driving.http.mapper.version.IVersionRequestMapper;
import projects.bootcamp.adapters.driving.http.mapper.version.IVersionResponsMapper;
import projects.bootcamp.domain.api.IVersionServicePort;


@RestController
@RequestMapping("/version")
@RequiredArgsConstructor
public class VersionRestControllerAdapter {
    private final IVersionServicePort versionServicePort;
    private final IVersionRequestMapper versionRequestMapper;
    private final IVersionResponsMapper versionResponsMapper;

    @PostMapping("/save")
    public ResponseEntity<VersionResponse> save (@Valid @RequestBody AddVersionRequest request){
        VersionResponse response = versionResponsMapper.toVersionResponse(versionServicePort.save(
                versionRequestMapper.toVersion(request)));
        return new ResponseEntity<>( response , HttpStatus.OK);
    }
}
