package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import projects.bootcamp.domain.model.Technology;
import java.util.Optional;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TechnologyAdapterTest {
    @Mock
    private ITechnologyRepository technologyRepository;
    @Mock
    private ITechnologyEntityMapper technologyEntityMapper;
    @InjectMocks
    private TechnologyAdapter technologyAdapter;
    final String name = "Java";
    final String description = "Herramienta para realizar pruebas unitarias";
    @Test
    void saveTechnologyCorrectamente() {
        Technology technology = new Technology(1,name, description);
        TechnologyEntity technologyEntityResp = new TechnologyEntity(1,name, description);

        when(technologyRepository.save(technologyEntityMapper.toTechnologyEntity(technology))).thenReturn(technologyEntityResp);
        when(technologyEntityMapper.toTechnologyModel(technologyEntityResp)).thenReturn(technology);
        final Optional<Technology> response = technologyAdapter.saveTechnology(technology);
        Assertions.assertEquals(technology, response);
    }

    @Test
    @DisplayName("Deberia devolver una exception cuando el nombre sea repetido en la base de datos")
    void saveTechnologyErrorBd() {
        Technology technology = new Technology(1,name, description);
        TechnologyEntity entityRespon = new TechnologyEntity(1, name, description);

        when(this.technologyRepository.findByName(technology.getName())).thenReturn(Optional.empty());
        assertThrows(ProductAlreadyExistsException.class, ()-> this.technologyAdapter.saveTechnology(technology));
    }

}