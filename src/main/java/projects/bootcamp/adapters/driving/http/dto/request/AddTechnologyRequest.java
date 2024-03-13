package projects.bootcamp.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class AddTechnologyRequest {
    private final String name;
    private final String description;
}
