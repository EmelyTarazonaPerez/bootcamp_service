package projects.bootcamp.adapters.driving.http.mapper.bootcamp;

import org.mapstruct.*;
import projects.bootcamp.adapters.driving.http.dto.request.bootcamp.AddBootcampRequest;
import projects.bootcamp.domain.model.Bootcamp;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IBootcampMapperRequest {
    @Mappings(value = {
            @Mapping(target = "idBootcamp", ignore = true),
            @Mapping(source = "name", target = "name"),
            @Mapping(source="description", target = "description"),
            @Mapping(source = "associatedCapacityList", target = "capacityList")
    })
    Bootcamp toBootcamp (AddBootcampRequest addBootcampRequest);
    @InheritInverseConfiguration
    AddBootcampRequest toAddBootcampRequest (Bootcamp bootcamp);

}
