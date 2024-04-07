package projects.bootcamp.adapters.driven.jpa.mysql.mapper;

import org.mapstruct.*;
import org.springframework.data.domain.Page;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.VersionEntity;
import projects.bootcamp.domain.model.Version;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IVersionEntityMapper {
    @Mappings(value = {
            @Mapping(source = "idVersion", target = "idVersion"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "cupMaxParticipant", target = "cupMaxParticipant"),
            @Mapping(source = "bootcamp", target = "bootcamp"),
            @Mapping(source = "version", target = "name")
    })
    Version toVersion (VersionEntity versionEntity);
    List<Version> toListVersion (Page<VersionEntity> list);

    @InheritInverseConfiguration
    VersionEntity toVersionEntity (Version version);
}
