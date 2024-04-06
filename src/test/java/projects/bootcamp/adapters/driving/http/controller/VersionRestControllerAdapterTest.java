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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import projects.bootcamp.adapters.driving.http.dto.request.version.AddVersionRequest;
import projects.bootcamp.adapters.driving.http.mapper.version.IVersionRequestMapper;
import projects.bootcamp.adapters.driving.http.mapper.version.IVersionResponsMapper;
import projects.bootcamp.contants.GetObjectVersion;
import projects.bootcamp.domain.api.IVersionServicePort;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class VersionRestControllerAdapterTest {

    @Mock
    private IVersionServicePort versionServicePort;
    @Mock
    private IVersionRequestMapper versionRequestMapper;
    @Mock
    private IVersionResponsMapper versionResponseMapper;
    @InjectMocks
    private VersionRestControllerAdapter versionRestControllerAdapter;
    private MockMvc mockMcv;

    @BeforeEach
    void setUp() {
         mockMcv = MockMvcBuilders.standaloneSetup(versionRestControllerAdapter)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }

    @Test
    @DisplayName("validar si se recibe correctamente la paticion de guardar una version")
    void saveControllerVersion() throws Exception {
        String versionJson = "{\"startDate\": \"2024-04-05\",\n" +
                "    \"endDate\": \"2024-06-05\",\n" +
                "    \"cupMaxParticipant\": 30,\n" +
                "    \"bootcamp\": {\n" +
                "        \"idBootcamp\": 11\n" +
                "    },\n" +
                "    \"name\" : \"Bootcamp A v2\"}";

        when(versionResponseMapper.toVersionResponse(versionServicePort.save(versionRequestMapper.toVersion(
                GetObjectVersion.getVersionRequest())))).thenReturn(GetObjectVersion.getVersionResponse());

        mockMcv.perform(post("/version/save")
                        .contentType(MediaType.valueOf("application/json"))
                        .content(versionJson))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("retorna status 400 si no cumple con los criterios de validacion")
    void saveControllerValidNull() throws Exception {
        String versionJson = "{\"startDate\": null," +
                "    \"endDate\": null," +
                "    \"cupMaxParticipant\": 30," +
                "    \"bootcamp\": {" +
                "        \"idBootcamp\": 11" +
                "    },\n" +
                "    \"name\" : \"Bootcamp A v2 Bootcamp A v2 Bootcamp A v2 Bootcamp A v2" +
                "Bootcamp A v2Bootcamp A v2Bootcamp A v2Bootcamp A v2Bootcamp A v2Bootcamp A v2\"}";

        mockMcv.perform(post("/version/save")
                        .contentType(MediaType.valueOf("application/json"))
                        .content(versionJson))
                .andExpect(status().isBadRequest());

    }

}