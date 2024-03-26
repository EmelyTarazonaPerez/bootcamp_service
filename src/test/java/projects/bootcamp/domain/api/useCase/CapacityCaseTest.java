package projects.bootcamp.domain.api.useCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import projects.bootcamp.domain.exception.ErrorListTechnologies;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.domain.spi.ICapacityPersistencePort;

import java.util.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CapacityCaseTest {
    @Mock
    private ICapacityPersistencePort capacityPersistencePort;
    @Mock
    private CapacityCase mockCapacityCase;
    @Mock
    private Pageable pegeableMock;
    @InjectMocks
    private CapacityCase capacityCase;

    //atributos
    private static List<Technology> technologyList = new ArrayList<>();
    private static List<Technology> technologyList2 = new ArrayList<>();


    @BeforeAll
    static void beforeAll() {
        Technology technology1 = new Technology(1, "Java", "Any description");
        Technology technology2 = new Technology(2, "Angular", "Any description");
        Technology technology3 = new Technology(3, "MySQL", "Any description");
        Technology technology4 = new Technology(4, "JUnit", "Any description");

        technologyList.add(technology1);
        technologyList.add(technology2);
        technologyList.add(technology3);

        technologyList2.add(technology1);
        technologyList2.add(technology2);
        technologyList2.add(technology3);
        technologyList2.add(technology4);
    }
    @Test
    @DisplayName("Guardar una capacidad correctamente")
    void save() {
        Capacity capacity = new Capacity(1, "Full Stack", "Any description",technologyList);
        Optional<Capacity> capacityOptional = Optional.of(capacity);

        when(capacityPersistencePort.save(capacity)).thenReturn(capacity);

        Capacity capacityResponse = capacityCase.save(capacity);
        Assertions.assertEquals(1, capacityResponse.getIdCapacity());
        Assertions.assertEquals("Full Stack", capacityResponse.getName());
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
        assertThrows(ErrorListTechnologies.class, ()-> this.capacityCase.save(capacity));

    }

    @Test
    @DisplayName("Retornar una lista de capacidades que tenga en sus tecnologias asociadas java")
    void getAllFilterJava() {
        Capacity capacity = new Capacity(1, "Full Stack", "Any description",technologyList);
        Capacity capacity2 = new Capacity(3, "Rollerblades backend", "Any description",technologyList);

        List<Capacity> capacities = new ArrayList<>();
        capacities.add(capacity);
        capacities.add(capacity2);

        when(capacityPersistencePort.getAll(pegeableMock)).thenReturn(capacities);
        List<Capacity> capacityResponse = capacityCase.getAll(pegeableMock, 0, "Java");
        assertEquals(capacities, capacityResponse);
    }

    @Test
    @DisplayName("Retornar una lista de capacidades con 4 techonogias")
    void getAllFilterByCantTech() {
        Capacity capacity = new Capacity(1, "Full Stack", "Any description",technologyList);
        Capacity capacity2 = new Capacity(3, "Rollerblades backend", "Any description",technologyList2);

        List<Capacity> capacities = new ArrayList<>();
        capacities.add(capacity);
        capacities.add(capacity2);

        when(capacityPersistencePort.getAll(pegeableMock)).thenReturn(capacities);
        List<Capacity> capacityResponse = capacityCase.getAll(pegeableMock, 4, "Java");
        assertEquals(capacity2, capacityResponse.get(0));
    }

    @Test
    @DisplayName("Retornar una lista de correctamente cuando no tenga parametros query")
    void getAll() {
        Capacity capacity = new Capacity(1, "Full Stack", "Any description",technologyList);
        Capacity capacity2 = new Capacity(3, "Rollerblades backend", "Any description",technologyList2);

        List<Capacity> capacities = new ArrayList<>();
        capacities.add(capacity);
        capacities.add(capacity2);

        when(capacityPersistencePort.getAll(pegeableMock)).thenReturn(capacities);
        List<Capacity> capacityResponse = capacityCase.getAll(pegeableMock, 0, null);
        assertEquals(capacities, capacityResponse);
    }
}