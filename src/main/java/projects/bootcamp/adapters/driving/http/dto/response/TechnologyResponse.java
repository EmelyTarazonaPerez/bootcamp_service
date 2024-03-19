package projects.bootcamp.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class TechnologyResponse {
    private final int id;
    private final String name;
    private final String description;
}
