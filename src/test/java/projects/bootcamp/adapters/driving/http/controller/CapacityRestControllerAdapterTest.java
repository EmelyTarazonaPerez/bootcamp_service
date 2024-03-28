package projects.bootcamp.adapters.driving.http.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import projects.bootcamp.adapters.driving.http.dto.request.capacity.AddCapacityRequest;
import projects.bootcamp.adapters.driving.http.dto.response.capacity.AssociatedTechnology;
import projects.bootcamp.adapters.driving.http.dto.response.capacity.CapacityResponse;
import projects.bootcamp.adapters.driving.http.mapper.capacity.ICapacityRequestMapper;
import projects.bootcamp.adapters.driving.http.mapper.capacity.ICapacityResponsMapper;
import projects.bootcamp.domain.api.ICapacityServicePort;
import projects.bootcamp.domain.model.Capacity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CapacityRestControllerAdapterTest {
    @Mock
    private ICapacityServicePort capacityServicePort;
    @Mock
    private ICapacityRequestMapper capacityRequestMapper;
    @Mock
    private ICapacityResponsMapper capacityResponsMapper;
    @InjectMocks
    private CapacityRestControllerAdapter capacityRestControllerAdapter;
    @Mock
    private Pageable pegeableMock;
    private MockMvc mockMcv;

    @BeforeEach
    void setUp() {
        mockMcv = MockMvcBuilders.standaloneSetup(capacityRestControllerAdapter)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }

    @Test
    @DisplayName("Deberia retornar lista de las capacidades con el nombre Java")
    void getAll() throws Exception {
        List<AssociatedTechnology> associatedTechnologies = new ArrayList<> ();

        associatedTechnologies.add( new AssociatedTechnology(1, "java"));
        associatedTechnologies.add( new AssociatedTechnology(2, "Angular"));
        associatedTechnologies.add( new AssociatedTechnology(3, "JUnit"));

        List<CapacityResponse> capacityResponses =
                Collections.singletonList(new CapacityResponse(1, "full stack", "any", associatedTechnologies));

        when(capacityResponsMapper.toListCapacityResponse(
                capacityServicePort.getAll(pegeableMock,0,"Java"))).thenReturn(capacityResponses);

        // Realizar solicitud GET
        mockMcv.perform(MockMvcRequestBuilders.get("/capacity")
                        .param("byCant", "0")
                        .param("nameTech", "Java")).andExpect(status().isOk());

    }


    @Test
    @DisplayName("Deberia insertar correctamente una capacidad y retornar status 200")
    void saveCapacity() throws Exception {
        String capacityJson = "{" +
                "\"name\": \"Desarrollador junior prueba\", " +
                "\"description\":\"Any description\"," +
                "\"addTechnologyRequestList\" : " +
                "[{\"idTechnology\":12, \"name\": \"Java\", \"description\" : \"Any description\"}," +
                "{\"idTechnology\":13, \"name\": \"Node.js\", \"description\" : \"Any description\"}," +
                "{\"idTechnology\":16, \"name\": \"JUnit\", \"description\" : \"Any description\"}]}";

        given(capacityServicePort.save(capacityRequestMapper.addRequestToCapacity(any(AddCapacityRequest.class))))
                .willReturn(new Capacity());

        mockMcv.perform(post("/capacity/save")
                        .contentType(MediaType.valueOf("application/json"))
                        .content(capacityJson))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Deberia no insertar una capacidad y retornar status 404")
    void dontSaveCapacityWhenEmptyPropierty() throws Exception {
        String capacityJson = "{" +
                "\"name\": null, " +
                "\"description\":\"Any description\"," +
                "\"addTechnologyRequestList\" : " +
                "[{\"idTechnology\":12, \"name\": \"Java\", \"description\" : \"Any description\"}," +
                "{\"idTechnology\":13, \"name\": \"Node.js\", \"description\" : \"Any description\"}," +
                "{\"idTechnology\":16, \"name\": \"JUnit\", \"description\" : \"Any description\"}]}";

        mockMcv.perform(post("/capacity/save")
                        .contentType(MediaType.valueOf("application/json"))
                        .content(capacityJson))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("No deberia aceptar una capacidad con el nombre muy largo")
    void dontSaveCapacityWhitNameLong() throws Exception {
        String capacityJson = "{" +
                "\"name\": \"---------------------------------------------------------------------------------------" +
                "------------------\", " +
                "\"description\":\"Any description\"," +
                "\"addTechnologyRequestList\" : " +
                "[{\"idTechnology\":12, \"name\": \"Java\", \"description\" : \"Any description\"}," +
                "{\"idTechnology\":13, \"name\": \"Node.js\", \"description\" : \"Any description\"}," +
                "{\"idTechnology\":16, \"name\": \"JUnit\", \"description\" : \"Any description\"}]}";

        mockMcv.perform(post("/capacity/save")
                        .contentType(MediaType.valueOf("application/json"))
                        .content(capacityJson))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("No deberia aceptar una capacidad con la descripcion muy largo")
    void dontSaveCapacityWhitDescriptionLong() throws Exception {
        String capacityJson = "{" +
                "\"name\": \"Full Stack prueba\", " +
                "\"description\":\"----------------------------------------------------------------------------------" +
                "-------------------------------------------------------------------------------------------------\"," +
                "\"addTechnologyRequestList\" : " +
                "[{\"idTechnology\":12, \"name\": \"Java\", \"description\" : \"Any description\"}," +
                "{\"idTechnology\":13, \"name\": \"Node.js\", \"description\" : \"Any description\"}," +
                "{\"idTechnology\":16, \"name\": \"JUnit\", \"description\" : \"Any description\"}]}";

        mockMcv.perform(post("/capacity/save")
                        .contentType(MediaType.valueOf("application/json"))
                        .content(capacityJson))
                .andExpect(status().isBadRequest());

    }
}