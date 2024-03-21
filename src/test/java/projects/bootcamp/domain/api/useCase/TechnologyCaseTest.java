package projects.bootcamp.domain.api.useCase;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ITechnologyPersistencePort;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TechnologyCaseTest {
    @Mock
    private ITechnologyPersistencePort technologyPersistencePort;
    @InjectMocks
    private TechnologyCase technologyCase;
    @Test
    @DisplayName("Deberia devolver una technologia si se registro correctamente en la base de datos")
    void createTechnology() {

        Technology technology = new Technology(1, "java", "una descripcion cualquiera");
        Optional<Technology> technologyOptional = Optional.of(technology);

        when(technologyPersistencePort.saveTechnology(technology)).thenReturn(technologyOptional);

        Optional<Technology> response = technologyCase.createTechnology(technology);
        assertThat(response).isPresent().contains(technology);
    }

    @Test
    @DisplayName("Deberia devolver un valor nulo si no se registro correctamente en la base de datos")
    void createTechnologyErrorBD() {

        Technology technology = new Technology(1, "java", "una descripcion cualquiera");

        when(technologyPersistencePort.saveTechnology(technology)).thenReturn(Optional.empty());

        Optional<Technology> response = technologyCase.createTechnology(technology);
        assertThat(response).isEmpty();
    }
}