package projects.bootcamp.domain.api.useCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import projects.bootcamp.domain.exception.ErrorListTechnologies;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.spi.IBootcampPersistencePort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static projects.bootcamp.contants.GetAssociatedTechList.getCapacityList;
@ExtendWith(MockitoExtension.class)
class BootcampCaseTest {
    @Mock
    private  IBootcampPersistencePort bootcampPersistencePort;
    @InjectMocks
    private BootcampCase bootcampCase;

    private Bootcamp bootcamp;
    @BeforeEach
    void setUp() {
        bootcamp = new Bootcamp(1, "test", "any", getCapacityList(3));
    }

    @Test
    @DisplayName("retornar un bootcamp cuando se guarde correctamente")
    void save() {
        when(this.bootcampPersistencePort.save(bootcamp)).thenReturn(bootcamp);
        final Bootcamp bootcampResult = bootcampCase.save(bootcamp);
        Assertions.assertEquals(1, bootcampResult.getIdBootcamp());
        Assertions.assertEquals("test", bootcampResult.getName());
    }

    @Test
    @DisplayName("retornar un exception las capacidades asociadas sean menores que uno")
    void saveErrorCaseUserAssociatedCapacity() {
        bootcamp = new Bootcamp(1, "test", "any", new ArrayList<>());
        assertThrows(ErrorListTechnologies.class, ()-> this.bootcampCase.save(bootcamp));

    }

    @Test
    @DisplayName("retornar un exception las capacidades asociadas sean mayores que 4")
    void saveErrorCaseUserAssociatedCapacity2() {
        bootcamp = new Bootcamp(1, "test", "any", getCapacityList(5));
        assertThrows(ErrorListTechnologies.class, ()-> this.bootcampCase.save(bootcamp));
    }
}