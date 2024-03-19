package projects.bootcamp.adapters.driving.http.dto.response.capacity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import projects.bootcamp.domain.model.Technology;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
public class CapacityResponse {
    private String name;
    private String description;
    private List<Technology> technologyList;
}
