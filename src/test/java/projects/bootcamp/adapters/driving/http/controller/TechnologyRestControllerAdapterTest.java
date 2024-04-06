package projects.bootcamp.adapters.driving.http.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import projects.bootcamp.adapters.driving.http.mapper.technology.ITechnologyRequestMapper;
import projects.bootcamp.adapters.driving.http.mapper.technology.ITechnologyResponseMapper;
import projects.bootcamp.domain.api.ITechnologyServicePort;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static projects.bootcamp.contants.GetAssociatedTechList.getTechnologyResponseList;

@ExtendWith(MockitoExtension.class)
class TechnologyRestControllerAdapterTest {
    @Mock
    private ITechnologyServicePort technologyPersistencePort;
    @Mock
    private ITechnologyRequestMapper technologyRequestMapper;
    @Mock
    private ITechnologyResponseMapper technologyResponseMapper;
    @InjectMocks
    private TechnologyRestControllerAdapter technologyRestControllerAdapter;

    private MockMvc mockMcv;
    @BeforeEach
    void setUp() {
        mockMcv = MockMvcBuilders.standaloneSetup(technologyRestControllerAdapter)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }
    @Test
    @DisplayName("Retornar status 200 si se retorna una  lista de technolias correctamente")
    void getAll() throws Exception {
        when(technologyResponseMapper.toListTechnologyResponse(technologyPersistencePort.getAll(0,5,false)))
                .thenReturn(getTechnologyResponseList());

        // Realize solicited GET
        mockMcv.perform(MockMvcRequestBuilders.get("/technology")
                        .param("sort", "false")
                        .param("size", "5")
                        .param("page", "0"))
                .andExpect(jsonPath("$[0].name").value("Java1"))
                .andExpect(status().isOk());
    }
}