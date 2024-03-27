package projects.bootcamp.adapters.driving.http.dto.response.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import projects.bootcamp.adapters.driving.http.dto.response.capacity.AssociatedTechnology;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
public class AssociatedCapacity {
    private int id;
    private String name;
    private List<AssociatedTechnology> technologyList;
}
