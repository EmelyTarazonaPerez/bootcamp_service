package projects.bootcamp.adapters.driving.http.dto.request.capacity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import projects.bootcamp.adapters.driving.http.dto.request.technology.AddTechnologyRequest;
import projects.bootcamp.config.Constants;
import projects.bootcamp.domain.model.Technology;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
public class AddCapacityRequest {
    @Valid
    @NotNull(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    @NotBlank(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    @Size(max = 50, message = Constants.LIMIT_STRING_NAME_TECHNOLOGY)
    private String name;
    @NotNull(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    @NotBlank(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    @Size(max = 50, message = Constants.LIMIT_STRING_NAME_TECHNOLOGY)
    private String description;
    @Size(max = 20, message = "las techonogias asociadas deben ser maximo 20 tecnologias")
    @Size(min = 3, message = "las techonogias asociadas deben ser minimo 3 tecnologias")
    private List<AddTechnologyRequest> addTechnologyRequestList;
}
