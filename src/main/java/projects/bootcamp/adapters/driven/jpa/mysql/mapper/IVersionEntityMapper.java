package projects.bootcamp.adapters.driven.jpa.mysql.mapper;

import org.mapstruct.*;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.VersionEntity;
import projects.bootcamp.domain.model.Version;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IVersionEntityMapper {
    @Mappings(value = {
            @Mapping(source = "idVersion", target = "idVersion"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "cupMaxParticipant", target = "cupMaxParticipant"),
            @Mapping(source = "bootcampEntityList", target = "bootcampList")
    })
    Version toVersion (VersionEntity versionEntity);

    @InheritInverseConfiguration
    VersionEntity toVersionEntity (Version version);
}
