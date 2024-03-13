package projects.bootcamp.adapters.driven.jpa.mysql.mapper;

import org.mapstruct.*;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import projects.bootcamp.domain.model.Technology;

import java.util.List;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ITechnologyEntityMapper {
    @Mappings({
        @Mapping(source = "idTechnology", target = "id_technology"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "description", target = "description"),
    })
    Technology toTechnologyModel(TechnologyEntity technologyEntity);
    List<Technology> toTechnologiesModel(List<Technology> technologiesEntity);

    @InheritInverseConfiguration
    TechnologyEntity toTechnologyEntity(Technology technologyModel);
    List<TechnologyEntity> toTechnologiesEntity(List<Technology> technologies);

}
