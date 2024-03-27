package projects.bootcamp.adapters.driving.http.dto.response.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;
@Data
@Getter
@AllArgsConstructor
public class BootcampResponse {
    private int idBootcamp;
    private String name;
    private List<AssociatedCapacity> capacityList;
}
