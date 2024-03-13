package projects.bootcamp.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateTechnologyRequest {

    private final int id;
    private final String name;
    private final String description;
}
