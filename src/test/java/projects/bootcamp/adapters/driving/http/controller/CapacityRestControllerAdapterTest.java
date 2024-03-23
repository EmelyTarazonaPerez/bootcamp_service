package projects.bootcamp.adapters.driving.http.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import projects.bootcamp.adapters.driving.http.dto.request.capacity.AddCapacityRequest;
import projects.bootcamp.adapters.driving.http.dto.request.technology.AddTechnologyRequest;
import projects.bootcamp.adapters.driving.http.mapper.capacity.ICapacityRequestMapper;
import projects.bootcamp.domain.api.ICapacityServicePort;
import projects.bootcamp.domain.model.Capacity;
import projects.bootcamp.domain.model.Technology;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CapacityRestControllerAdapterTest {
    @Mock
    private ICapacityServicePort capacityServicePort;
    @Mock
    private  ICapacityRequestMapper capacityRequestMapper;
    @InjectMocks
    private CapacityRestControllerAdapter capacityRestControllerAdapter;
    private MockMvc mockMcv;

    private Capacity capacity;
    private Optional<Capacity> capacityOptional;
    private AddCapacityRequest addCapacityRequest;
    private List<Technology> technologyList;
    private List<AddTechnologyRequest> addTechnologyRequestList;



    @BeforeEach
    void setUp(){
        mockMcv = MockMvcBuilders.standaloneSetup(capacityRestControllerAdapter).build();
    }

    /*
    @Test
    @DisplayName("Deberia insertar correctamente una capacidad")
    void capacity () throws Exception {
        technologyList.add(new Technology(1, "Java", "any description"));
        technologyList.add(new Technology(2, "Angular", "any description"));
        technologyList.add(new Technology(3, "MySQL", "any description"));
        capacity = new Capacity(1, "Full stack", "any description", this.technologyList);


        when(capacityServicePort.save(capacityRequestMapper.addRequestToCapacity(any(AddCapacityRequest.class))))
                .thenReturn(new ResponseEntity<>(capacity, HttpStatusCode.valueOf(200)));

    }
   */
}