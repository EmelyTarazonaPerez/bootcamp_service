package projects.bootcamp.adapters.driving.http.dto.response.capacity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class AssociatedTechnology {
    private int idTechnology;
    private String name;
}
