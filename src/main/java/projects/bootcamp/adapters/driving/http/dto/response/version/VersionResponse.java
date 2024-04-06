package projects.bootcamp.adapters.driving.http.dto.response.version;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class VersionResponse {
    private int idVersion;
    private LocalDate startDate;
    private LocalDate endDate;
    private int cupMaxParticipant;
    private AssociatedBootcamp bootcamp;
    private String name;
}
