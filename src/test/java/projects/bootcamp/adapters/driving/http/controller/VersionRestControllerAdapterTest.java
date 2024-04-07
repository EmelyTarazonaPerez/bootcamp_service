package projects.bootcamp.adapters.driving.http.controller;

import org.junit.jupiter.api.Assertions;
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
import projects.bootcamp.adapters.driving.http.dto.request.version.AddVersionRequest;
import projects.bootcamp.adapters.driving.http.dto.response.version.VersionResponse;
import projects.bootcamp.adapters.driving.http.mapper.version.IVersionRequestMapper;
import projects.bootcamp.adapters.driving.http.mapper.version.IVersionResponsMapper;
import projects.bootcamp.contants.GetObjectVersion;
import projects.bootcamp.domain.api.IVersionServicePort;
import projects.bootcamp.domain.model.Version;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

    @Test
    @DisplayName("retornar status 200 si se recibe y se ejecuta correctamente la peticon get")
    void getAll() throws Exception {
        List<Version> versionList = GetObjectVersion.getListVersion();
        List<VersionResponse> versionResponses = GetObjectVersion.getListVersionResponse();

        when(versionServicePort.getAll(0,10, "version", false, 0))
                .thenReturn(versionList);
        when(versionResponseMapper.toListVersionResponse(versionList)).thenReturn(versionResponses);

        mockMcv.perform(MockMvcRequestBuilders.get("/version")
                        .param("page", "0")
                        .param("size", "10")
                        .param("orderByProperty", "version")
                        .param("direction", "false")
                        .param("idBootcamp", "0"))
                .andExpect(jsonPath("$[0].name").value("1"))
                .andExpect(status().isOk());
    }

}