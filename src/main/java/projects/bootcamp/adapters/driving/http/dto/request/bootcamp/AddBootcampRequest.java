package projects.bootcamp.adapters.driving.http.dto.request.bootcamp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import projects.bootcamp.config.Constants;
import projects.bootcamp.domain.model.Capacity;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
public class AddBootcampRequest {
    @NotNull(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    @NotBlank(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    @Size(max = 50, message = Constants.LIMIT_STRING_NAME_TECHNOLOGY)
    private String name;

    @NotNull(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    @NotBlank(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    @Size(max = 90, message = Constants.LIMIT_STRING_NAME_TECHNOLOGY)
    private String description;

    @Size(max = 4, message = "las techonogias asociadas deben ser maximo 4 tecnologias")
    @Size(min = 1, message = "las techonogias asociadas deben ser minimo 1 tecnologias")
    private List<Capacity> associatedCapacityList;
}
