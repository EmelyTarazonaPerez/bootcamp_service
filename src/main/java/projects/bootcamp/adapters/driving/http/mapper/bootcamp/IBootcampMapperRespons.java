package projects.bootcamp.adapters.driving.http.mapper.bootcamp;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import projects.bootcamp.adapters.driving.http.dto.response.bootcamp.BootcampResponse;
import projects.bootcamp.domain.model.Bootcamp;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IBootcampMapperRespons {
    @Mappings(value = {
            @Mapping(source = "idBootcamp", target = "idBootcamp"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "capacityList", target = "capacityList")
    })
    BootcampResponse toBootcampResponse(Bootcamp bootcamp);
    List<BootcampResponse> toBootcampResponseList(List<Bootcamp> bootcampList);
}
