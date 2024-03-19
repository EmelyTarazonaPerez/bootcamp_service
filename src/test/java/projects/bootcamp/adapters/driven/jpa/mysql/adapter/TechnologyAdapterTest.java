package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;

import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TechnologyAdapterTest {
    @Mock
    private  ITechnologyRepository technologyRepository;
    @Mock
    private ITechnologyEntityMapper technologyEntityMapper;
    @InjectMocks
    private TechnologyAdapter technologyAdapter;

    final String name = "Mockito";
    final String description = "Herramienta para realizar pruebas unitarias";
    @Test
    void saveTechnology() {
        Technology technology = new Technology(1,name, description);
        TechnologyEntity technologyEntity = new TechnologyEntity(1,name, description, null);

        when(technologyEntityMapper.toTechnologyEntity(technology)).thenReturn(technologyEntity);
        when(technologyRepository.save(technologyEntity)).thenReturn(technologyEntity);

        final TechnologyEntity response = technologyAdapter.saveTechnology(technology);
        Assertions.assertEquals(1, response.getIdTechnology());
        Assertions.assertEquals(name, response.getName());
        Assertions.assertEquals(description, response.getDescription());
    }

    @Test
    void getAll() {
        Technology technology = new Technology(1,name, description);
        TechnologyEntity technologyEntity = new TechnologyEntity(1,name, description, null);
        Pageable pagination = PageRequest.of(0,5, Sort.by(Sort.Direction.ASC, "name"));

        when(technologyRepository.findAll()).thenReturn(Arrays.asList(technologyEntity));
        when(technologyEntityMapper.toTechnologiesModel(Arrays.asList(technologyEntity))).thenReturn(Arrays.asList(technology));

        final List<Technology> response = technologyAdapter.getAll(pagination);
        Assertions.assertEquals(1, response.get(0).getIdTechnology());
        Assertions.assertEquals(name, response.get(0).getName());
        Assertions.assertEquals(description, response.get(0).getDescription());
    }
}