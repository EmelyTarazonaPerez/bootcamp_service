package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projects.bootcamp.adapters.driven.jpa.mysql.adapter.BootcampAdapter;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import projects.bootcamp.domain.model.Bootcamp;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static projects.bootcamp.contants.GetAssociatedTechList.getCapacityEntityList;
import static projects.bootcamp.contants.GetAssociatedTechList.getCapacityList;

@ExtendWith(MockitoExtension.class)
class BootcampAdapterTest {

    @Mock()
    private IBootcampRepository bootcampRepository;
    @Mock()
    private IBootcampEntityMapper bootcampEntityMapper;
    @InjectMocks
    private BootcampAdapter bootcampAdapter;
    @Mock
    private Pageable pegeableMock;
    @Test
    void getAll() {
        List<Bootcamp> bootcamp = new ArrayList<>();
        bootcamp.add(new Bootcamp(1, "name", "any", getCapacityList(2)));

        when(bootcampEntityMapper.toBootcampList(bootcampRepository.findAll(any(Pageable.class))))
                .thenReturn(bootcamp);

        List<Bootcamp> result = bootcampAdapter.getAll(10, 0, false, false);

        Assertions.assertEquals(bootcamp, result);
        assertNotNull(result);
    }

    @Test
    @DisplayName("retornar un bootcamp cuando este guarde correctamente")
    void save() {
        BootcampEntity bootcampEntity = new BootcampEntity(1, "name", "any", getCapacityEntityList(2));
        Bootcamp bootcamp = new Bootcamp(1, "name", "any", getCapacityList(2));

        when(bootcampEntityMapper.toBootcampEntity( any(Bootcamp.class))).thenReturn(bootcampEntity);
        when(bootcampRepository.save(bootcampEntity)).thenReturn(bootcampEntity);
        when(bootcampEntityMapper.toBootcamp(bootcampEntity)).thenReturn(bootcamp);

        final Bootcamp result = bootcampAdapter.save(bootcamp);

        Assertions.assertEquals(bootcamp, result);
        assertNotNull(bootcampEntity);
        assertEquals(1, bootcampEntity.getIdBootcamp());
        assertEquals("name", bootcampEntity.getName());
        assertEquals("any", bootcampEntity.getDescription());
        assertEquals(2, bootcampEntity.getCapacityEntityList().size());

        assertNotNull(result);
        assertEquals(1, result.getIdBootcamp());
        assertEquals("name", result.getName());
        assertEquals("any", result.getDescription());
        assertEquals(2, result.getCapacityList().size());
    }
}