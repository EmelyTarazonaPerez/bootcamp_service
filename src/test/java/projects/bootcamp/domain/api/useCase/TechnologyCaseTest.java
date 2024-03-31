package projects.bootcamp.domain.api.useCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ITechnologyPersistencePort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static projects.bootcamp.contants.GetAssociatedTechList.getTechnologyList;

@ExtendWith(MockitoExtension.class)
class TechnologyCaseTest {

    @Mock
    private ITechnologyPersistencePort technologyPersistencePort;
    @InjectMocks
    private TechnologyCase technologyCase;
    @BeforeEach
    void setUp() {
    }
    @Test
    @DisplayName("Retornar una lista de technologia si se recibe correctamente la la informacion del adapter")
    void getAll() {
        List<Technology> technologyList = getTechnologyList();
        when(technologyPersistencePort.getAll(0,10,false)).thenReturn(technologyList);

        final  List<Technology> result = technologyCase.getAll(0,10,false);

        assertEquals(technologyList, result);
    }

    @Test
    @DisplayName("Retornar una tecnologia si esta es guardada correctamente")
    void createTechnology() {
        Technology technology = new Technology(1,"Java", "Any");
        when(technologyPersistencePort.saveTechnology(technology)).thenReturn(Optional.of(technology));

        final Optional<Technology> result = technologyCase.createTechnology(technology);
        assertEquals(Optional.of(technology), result);

    }
}