package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;

import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void saveTechnologyCorrectamente() {
        Technology technology = new Technology(1,name, description);
        TechnologyEntity technologyEntityResp = new TechnologyEntity(1,name, description, null);

        when(technologyRepository.save(technologyEntityMapper.toTechnologyEntity(technology))).thenReturn(technologyEntityResp);
        when(technologyEntityMapper.toTechnologyModel(technologyEntityResp)).thenReturn(technology);

        final Optional<Technology> response = technologyAdapter.saveTechnology(technology);
        Assertions.assertEquals(1, response.get().getIdTechnology());
        Assertions.assertEquals(name, response.get().getName());
    }


    @Test
    @DisplayName("Deberia devolver una exception cuando el nombre sea repetido en la base de datos")
    void saveTechnologyErrorBd() {
         Technology technology = new Technology(1,name, description);

         when(this.technologyRepository.findByName(technology.getName())).thenReturn(Optional.empty());
         assertThrows(ProductAlreadyExistsException.class, ()-> this.technologyAdapter.saveTechnology(technology));
    }
}
