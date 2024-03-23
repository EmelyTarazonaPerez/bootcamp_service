package projects.bootcamp.domain.api.useCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import projects.bootcamp.domain.exception.ErrorListTechnologies;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ICapacityPersistencePort;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.*;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CapacityCaseTest {
    @Mock
    private ICapacityPersistencePort capacityPersistencePort;
    @Mock
    private CapacityCase mockCapacityCase;
    @InjectMocks
    private CapacityCase capacityCase;
    @Test
    @DisplayName("Guardar una capacidad correctamente")
    void save() {
        Technology technology1 = new Technology(1, "Java", "Any description");
        Technology technology2 = new Technology(2, "Angular", "Any description");
        Technology technology3 = new Technology(3, "MySQL", "Any description");

        List<Technology> technologyList = new ArrayList<>();

        technologyList.add(technology1);
        technologyList.add(technology2);
        technologyList.add(technology3);

        Capacity capacity = new Capacity(1, "Full Stack", "Any description",technologyList);
        Optional<Capacity> capacityOptional = Optional.of(capacity);

        when(capacityPersistencePort.save(capacity)).thenReturn(capacity);

        Capacity capacityRespon = capacityCase.save(capacity);
    }

    @Test
    @DisplayName("retornar error cuando dos technologias insertadas sean iguales")
    void saveWhenTechnologuisEquals() {
        Technology technology1 = new Technology(1, "Java", "Any description");
        Technology technology2 = new Technology(1, "Java", "Any description");
        Technology technology3 = new Technology(3, "MySQL", "Any description");

        List<Technology> technologyList = new ArrayList<>();

        technologyList.add(technology1);
        technologyList.add(technology2);
        technologyList.add(technology3);

        Capacity capacity = new Capacity(1, "Full Stack", "Any description",technologyList);
        Set<Technology> technologySet = new HashSet<>(technologyList);

        assertThrows(ErrorListTechnologies.class, ()-> this.capacityCase.save(capacity));

    }

    @Test
    @DisplayName("retornar error cuando las technologias relacionadas sean menor que 3 o mayor que 20")
    void allowedSizeLimit() {
        Technology technology1 = new Technology(1, "Java", "Any description");
        List<Technology> technologyList = new ArrayList<>();
        technologyList.add(technology1);

        Capacity capacity = new Capacity(1, "Full Stack", "Any description",technologyList);
        assertThrows(ErrorListTechnologies.class, ()-> this.capacityCase.save(capacity));
    }
}