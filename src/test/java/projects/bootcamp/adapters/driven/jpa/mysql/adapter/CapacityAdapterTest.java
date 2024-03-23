package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.model.Technology;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CapacityAdapterTest {

    @Mock
    private ICapacityRepository capacityRepository;
    @Mock
    private ICapacityEntityMapper capacityEntityMapper;

    @InjectMocks
    private CapacityAdapter capacityAdapter;

    @Test
    @DisplayName("return a capacity if capacity saved correctly")
    void saveCapacityBD() {
        final List<TechnologyEntity> technologyEntitylist = getTechnologyEntityList();

        List<Technology> technologyList = new ArrayList<>();

        Capacity capacity = new Capacity(1, "Full Stack", "Any description",technologyList);
        CapacityEntity capacityEntity = new CapacityEntity(1, "Full stack", "Any description", technologyEntitylist);

        //When
        when(this.capacityEntityMapper.toCapacityEntity(capacity)).thenReturn(capacityEntity);
        when(this.capacityRepository.save(capacityEntity)).thenReturn(capacityEntity);
        when(this.capacityEntityMapper.toCapacity(capacityEntity)).thenReturn(capacity);

        final Capacity capacityResponse = capacityAdapter.save(capacity);
        Assertions.assertEquals(1, capacityResponse.getIdCapacity());
        Assertions.assertEquals(capacity.getName(), capacityResponse.getName());
    }

    private static List<TechnologyEntity> getTechnologyEntityList() {
        TechnologyEntity technology1 = new TechnologyEntity(1, "Java1", "Any description", null);
        TechnologyEntity technology2 = new TechnologyEntity(2, "Java2", "Any description", null);
        TechnologyEntity technology3 = new TechnologyEntity(3, "Java3", "Any description", null);

        List<TechnologyEntity> technologyEntitylist = new ArrayList<>();
        technologyEntitylist.add(technology1);
        technologyEntitylist.add(technology2);
        technologyEntitylist.add(technology3);
        return technologyEntitylist;
    }
}