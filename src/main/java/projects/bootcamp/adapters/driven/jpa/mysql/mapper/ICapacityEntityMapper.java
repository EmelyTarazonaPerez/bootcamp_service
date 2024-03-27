package projects.bootcamp.adapters.driven.jpa.mysql.mapper;

import org.mapstruct.*;
import org.springframework.data.domain.Page;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import projects.bootcamp.domain.model.Capacity;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ICapacityEntityMapper {
    @Mappings(value = {
            @Mapping(source = "idCapacity", target = "idCapacity"),
            @Mapping(source="name", target="name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "technologyList", target = "technologyList")
    })
    Capacity toCapacity (CapacityEntity capacityEntity);
    List<Capacity> toCapacityList (Page<CapacityEntity> capacityEntityList);
    @InheritInverseConfiguration
    CapacityEntity toCapacityEntity (Capacity capacity);
}
