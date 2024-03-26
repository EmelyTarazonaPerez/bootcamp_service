package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.model.Technology;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static projects.bootcamp.contants.GetAssociatedTechList.getTechnologyEntityList;

@ExtendWith(MockitoExtension.class)
class CapacityAdapterTest {

    @Mock
    private ICapacityRepository capacityRepository;
    @Mock
    private ICapacityEntityMapper capacityEntityMapper;
    @Mock
    private Pageable pegeableMock;
    @InjectMocks
    private CapacityAdapter capacityAdapter;

    @Test
    @DisplayName("return a capacity if capacity saved correctly")
    void saveCapacityBD() {
        Capacity capacity = new Capacity(1, "Full Stack", "Any description", new ArrayList<>());
        CapacityEntity capacityEntity = new CapacityEntity(1, "Full stack", "Any description", getTechnologyEntityList(), null);
        //When
        when(this.capacityEntityMapper.toCapacityEntity(capacity)).thenReturn(capacityEntity);
        when(this.capacityRepository.save(capacityEntity)).thenReturn(capacityEntity);
        when(this.capacityEntityMapper.toCapacity(capacityEntity)).thenReturn(capacity);

        final Capacity capacityResponse = capacityAdapter.save(capacity);
        Assertions.assertEquals(1, capacityResponse.getIdCapacity());
        Assertions.assertEquals(capacity.getName(), capacityResponse.getName());
    }
    @Test
    @DisplayName("Retornar error si una capacidad ya existe en la base de datos")
    void saveErrorBD() {
        when(capacityRepository.save(any(CapacityEntity.class))).thenThrow(new ProductAlreadyExistsException("message"));
        assertThrows(ProductAlreadyExistsException.class, ()-> {
            this.capacityAdapter.save(new Capacity());
        });
    }
    @Test
    @DisplayName("Guardar retornar lista de capacidades en la base de datos")
    void getAll() {
        List<Capacity> capacities = new ArrayList<>();
        when(capacityEntityMapper.toCapacityList(capacityRepository.findAll(pegeableMock))).thenReturn(capacities);
        final List<Capacity> capacityList = capacityAdapter.getAll(pegeableMock);
         assertNotNull(capacityList);
    }

}