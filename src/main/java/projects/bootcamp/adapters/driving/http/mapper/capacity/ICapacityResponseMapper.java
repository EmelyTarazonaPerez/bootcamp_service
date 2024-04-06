package projects.bootcamp.adapters.driving.http.mapper.capacity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import projects.bootcamp.adapters.driving.http.dto.response.capacity.CapacityResponse;
import projects.bootcamp.domain.model.Capacity;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ICapacityResponseMapper {

    @Mappings(value = {
            @Mapping(source = "idCapacity", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "technologyList", target = "technologyList"),
    })
    CapacityResponse toCapacityResponse (Capacity capacity);
    List<CapacityResponse> toListCapacityResponse (List<Capacity> capacityList);
}
