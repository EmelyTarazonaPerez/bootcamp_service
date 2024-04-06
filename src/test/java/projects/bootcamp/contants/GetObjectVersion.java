package projects.bootcamp.contants;

import projects.bootcamp.adapters.driving.http.dto.request.version.AddVersionRequest;
import projects.bootcamp.adapters.driving.http.dto.response.version.AssociatedBootcamp;
import projects.bootcamp.adapters.driving.http.dto.response.version.VersionResponse;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.model.Version;

import java.time.LocalDate;

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
}
