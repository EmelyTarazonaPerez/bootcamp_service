package projects.bootcamp.adapters.driven.jpa.mysql.mapper;

import org.mapstruct.*;
import org.springframework.data.domain.Page;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.model.Capacity;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IBootcampEntityMapper {
    @Mappings(value = {
            @Mapping(source = "idBootcamp", target = "idBootcamp"),
            @Mapping(source="name", target="name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "capacityEntityList", target = "capacityList")
    })
    Bootcamp toBootcamp (BootcampEntity bootcampEntity);
    @InheritInverseConfiguration
    BootcampEntity toBootcampEntity (Bootcamp capacity);
}
