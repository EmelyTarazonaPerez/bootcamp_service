package projects.bootcamp.adapters.driving.http.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import projects.bootcamp.adapters.driving.http.dto.request.bootcamp.AddBootcampRequest;
import projects.bootcamp.adapters.driving.http.dto.request.capacity.AddCapacityRequest;
import projects.bootcamp.adapters.driving.http.dto.response.bootcamp.BootcampResponse;
import projects.bootcamp.adapters.driving.http.mapper.bootcamp.IBootcampMapperRequest;
import projects.bootcamp.adapters.driving.http.mapper.bootcamp.IBootcampMapperRespons;
import projects.bootcamp.domain.api.IBootcampServicePort;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.spi.IBootcampPersistencePort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static projects.bootcamp.contants.GetAssociatedTechList.getCapacityList;
import static projects.bootcamp.contants.GetAssociatedTechList.getCapacityResponseList;

@ExtendWith(MockitoExtension.class)
class BootcampRestControllerAdapterTest {

    @Mock
    private IBootcampServicePort bootcampServicePort;
    @Mock
    private IBootcampMapperRequest bootcampMapperRequest;
    @Mock
    private IBootcampMapperRespons bootcampMapperRespons;
    @InjectMocks
    private BootcampRestControllerAdapter bootcampRestControllerAdapter;

    private Bootcamp bootcamp;
    private MockMvc mockMcv;
    @BeforeEach
    void setUp() {
        bootcamp = new Bootcamp(1, "test", "any", getCapacityList(3));
        mockMcv = MockMvcBuilders.standaloneSetup(bootcampRestControllerAdapter)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }

    @Test
    @DisplayName("deberia retornar status 200 al recibir la peticion de guardar un bootcamp")
    void save() throws Exception {
        String capacityJson = "{" +
                "\"name\": \"prueba\", " +
                "\"description\":\"Any description\"," +
                "\"associatedCapacityList\" : " +
                "[{\"idCapacity\":39}]}";

        given(bootcampServicePort.save(bootcampMapperRequest.toBootcamp(any(AddBootcampRequest.class))))
                .willReturn(new Bootcamp());

        mockMcv.perform(post("/bootcamp/save")
                        .contentType(MediaType.valueOf("application/json"))
                        .content(capacityJson))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("deberia retornar status 400 al recibir la peticion de guardar un bootcamp")
    void saveErrorValid() throws Exception {
        String capacityJson = "{" +
                "\"name\": \"prueba--------------------------------------------" +
                "---------------------------------------------------------------\", " +
                "\"description\":\"Any description\"," +
                "\"associatedCapacityList\" : " +
                "[{\"idCapacity\":39}]}";

        mockMcv.perform(post("/bootcamp/save")
                        .contentType(MediaType.valueOf("application/json"))
                        .content(capacityJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("deberia retornar status 400 al recibir un parametro null")
    void saveErrorValidNull() throws Exception {
        String capacityJson = "{" +
                "\"name\": null, " +
                "\"description\":\"Any description\"," +
                "\"associatedCapacityList\" : " +
                "[{\"idCapacity\":39}]}";

        mockMcv.perform(post("/bootcamp/save")
                        .contentType(MediaType.valueOf("application/json"))
                        .content(capacityJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("deberia retornar status 400 al no recibir capacidades asociadas")
    void saveErrorValidAssociatedCapacity() throws Exception {
        String capacityJson = "{" +
                "\"name\": \"prueba\", " +
                "\"description\":\"Any description\"," +
                "\"associatedCapacityList\" : " +
                "[]}";

        mockMcv.perform(post("/bootcamp/save")
                        .contentType(MediaType.valueOf("application/json"))
                        .content(capacityJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Retornar status 200 cuando se recibe la peticion")
    void getAll() throws Exception {
        List<BootcampResponse> responseList = new ArrayList<>();
        responseList.add(new BootcampResponse(1, "nombre", getCapacityResponseList(3)));

        when(bootcampMapperRespons.toBootcampResponseList(bootcampServicePort.getAll(0, 10, false, false))).thenReturn(responseList);

        mockMcv.perform(get("/bootcamp")
                        .param("page", "0")
                        .param("size", "10")
                        .param("directionTechAssociated", "false")
                        .param("order", "false"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].idBootcamp").value(1))
                .andExpect(jsonPath("$[0].name").value("nombre"));
    }
}