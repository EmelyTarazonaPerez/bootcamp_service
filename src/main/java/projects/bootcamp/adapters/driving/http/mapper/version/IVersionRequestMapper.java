package projects.bootcamp.adapters.driving.http.mapper.version;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import projects.bootcamp.adapters.driving.http.dto.request.version.AddVersionRequest;
import projects.bootcamp.domain.model.Version;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IVersionRequestMapper {

    @Mappings( value = {
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "cupMaxParticipant", target = "cupMaxParticipant"),
            @Mapping(source = "bootcamp", target = "bootcamp"),
            @Mapping(source = "name", target = "name")
    })
    Version toVersion(AddVersionRequest request);

}
