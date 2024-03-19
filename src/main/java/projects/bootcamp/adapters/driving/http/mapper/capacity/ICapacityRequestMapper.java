package projects.bootcamp.adapters.driving.http.mapper.capacity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import projects.bootcamp.adapters.driving.http.dto.request.capacity.AddCapacityRequest;
import projects.bootcamp.domain.model.Capacity;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ICapacityRequestMapper {
    @Mappings(value = {
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "addTechnologyRequestList", target = "technologyList")
    })
    Capacity addRequestToCapacity(AddCapacityRequest addCapacityRequest);
}
