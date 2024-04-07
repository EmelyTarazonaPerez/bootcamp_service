package projects.bootcamp.adapters.driving.http.dto.request.version;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import projects.bootcamp.config.Constants;
import projects.bootcamp.domain.model.Bootcamp;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class AddVersionRequest {
    @NotNull(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    private LocalDate startDate;
    @NotNull(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    private LocalDate endDate;
    @NotNull(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    private int cupMaxParticipant;
    @NotNull(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    private Bootcamp bootcamp;
    @NotNull(message = Constants.EMPTY_FIELD_EXCEPTION_MESSAGE)
    @Size(max = 50, message = Constants.LIMIT_STRING_NAME_VERSION)
    private String name;
}
