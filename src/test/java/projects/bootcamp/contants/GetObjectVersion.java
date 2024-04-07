package projects.bootcamp.contants;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.VersionEntity;
import projects.bootcamp.adapters.driving.http.dto.request.version.AddVersionRequest;
import projects.bootcamp.adapters.driving.http.dto.response.version.AssociatedBootcamp;
import projects.bootcamp.adapters.driving.http.dto.response.version.VersionResponse;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.model.Version;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetObjectVersion {

    public static Version getVersion() {
        return  new Version(
                1,
                LocalDate.now(),
                LocalDate.of(2024,12,6),
                50,
                new Bootcamp(),
                "1" );
    }

    public static VersionEntity getVersionEntity() {
        return  new VersionEntity(
                1,
                LocalDate.now(),
                LocalDate.of(2024,12,6),
                50,
                new BootcampEntity(),
                "1" );
    }

    public static VersionResponse getVersionResponse() {
        return  new VersionResponse(
                1,
                LocalDate.now(),
                LocalDate.of(2024,12,6),
                50,
                new AssociatedBootcamp(11),
                "1" );
    }

    public static AddVersionRequest getVersionRequest() {
        return  new AddVersionRequest(
                LocalDate.now(),
                LocalDate.of(2024,12,6),
                50,
                new Bootcamp(),
                "1" );
    }

    public static List<Version> getListVersion () {
        Version version1 = getVersion();
        version1.setIdVersion(2);
        version1.getBootcamp().setIdBootcamp(10);
        version1.setName("2");

        List<Version> versions = new ArrayList<>();
        versions.add(version1);
        versions.add(getVersion());

        return versions;
    }

    public static Page<VersionEntity> getPageVersionEntity () {
        VersionEntity version1 = getVersionEntity();
        version1.setIdVersion(2);
        version1.getBootcamp().setIdBootcamp(10);
        version1.setVersion("2");

        List<VersionEntity> versionList = new ArrayList<>();
        versionList.add(version1);
        versionList.add(getVersionEntity());

        // Crear una instancia de Page usando PageImpl
        return new PageImpl<>(versionList);
    }

    public static List<VersionResponse> getListVersionResponse () {
        VersionResponse version1 = getVersionResponse();
        VersionResponse version2 =  new VersionResponse(
                2,
                LocalDate.now(),
                LocalDate.of(2024,12,6),
                50,
                new AssociatedBootcamp(10),
                "2" );

        List<VersionResponse> versions = new ArrayList<>();
        versions.add(version1);
        versions.add(version2);

        return versions;
    }
}
