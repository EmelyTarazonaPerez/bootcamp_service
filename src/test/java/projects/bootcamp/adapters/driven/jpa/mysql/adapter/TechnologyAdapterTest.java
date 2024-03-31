package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import projects.bootcamp.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import projects.bootcamp.domain.model.Technology;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static projects.bootcamp.contants.GetAssociatedTechList.getTechnologyList;

@ExtendWith(MockitoExtension.class)
class TechnologyAdapterTest {
    @Mock
    private  ITechnologyRepository technologyRepository;
    @Mock
    private ITechnologyEntityMapper technologyEntityMapper;
    @Mock
    private Pageable pageable;
    @InjectMocks
    private TechnologyAdapter technologyAdapter;
    private List<Technology> technologies;
    final String name = "Mockito";
    final String description = "Herramienta para realizar pruebas unitarias";

    @BeforeEach
    void setUp() {
    this.technologies = getTechnologyList();
    }
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
        when(technologyRepository.save(any(TechnologyEntity.class)))
                .thenThrow(new ProductAlreadyExistsException("message"));
         assertThrows(ProductAlreadyExistsException.class, ()-> this.technologyAdapter.saveTechnology(technology));
    }
    @Test
    @DisplayName("Deberia retornar una lista de technologias si se hace el llamado correcto a la BD")
    void getAll() {
        when(this.technologyEntityMapper.toTechnologiesModel(this.technologyRepository.findAll(pageable)))
                .thenReturn(technologies);

        final List<Technology> result = this.technologyAdapter.getAll(0, 10, false);

        assertEquals(technologies, result);
    }
}
