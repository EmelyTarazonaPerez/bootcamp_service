package projects.bootcamp.adapters.driving.http.mapper.version;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import projects.bootcamp.adapters.driving.http.dto.response.capacity.CapacityResponse;
import projects.bootcamp.adapters.driving.http.dto.response.version.VersionResponse;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.model.Version;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IVersionResponsMapper {
    @Mappings(value = {
            @Mapping(source = "idVersion", target = "idVersion"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "cupMaxParticipant", target = "cupMaxParticipant"),
            @Mapping(source = "bootcamp", target = "bootcamp"),
            @Mapping(source = "name", target = "name")
    })
    VersionResponse toVersionResponse (Version version);
}
