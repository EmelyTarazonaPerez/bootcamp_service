package projects.bootcamp.adapters.driven.jpa.mysql.mapper;

import org.mapstruct.*;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import projects.bootcamp.domain.model.Capacity;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ICapacityEntityMapper {
    @Mappings(value = {
            @Mapping(source = "idCapacity", target = "idCapacity"),
            @Mapping(source="name", target="name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "technologyEntityList", target = "technologyList")
    })
    Capacity toCapacity (CapacityEntity capacityEntity);
    @InheritInverseConfiguration
    CapacityEntity toCapacityEntity (Capacity capacity);
}
