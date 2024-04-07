package projects.bootcamp.domain.api.useCase;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import projects.bootcamp.contants.GetObjectVersion;
import projects.bootcamp.domain.exception.ValidationErrorHandler;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.model.Version;
import projects.bootcamp.domain.spi.IVersionPersistencePort;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class VersionCaseTest {
    @Mock
    private IVersionPersistencePort versionPersistencePort;

    @Mock
    private VersionCase versionCaseMock;
    @InjectMocks
    private VersionCase versionCase;

    private Version versionCheck;

    @BeforeEach
    void beforeAll() {
        versionCheck = GetObjectVersion.getVersion();
    }

    @Test
    @DisplayName("retornar una version si se ha transferido correctamente")
    void saveVersion() {
        versionCheck.getBootcamp().setIdBootcamp(11);
        when(this.versionPersistencePort.save(versionCheck)).thenReturn(versionCheck);
        final Version result = versionCase.save(versionCheck);
        Assertions.assertEquals(versionCheck, result);
    }

    @Test
    @DisplayName("retornar una exception si fecha de final es menor a fecha de inicio")
    void saveVersionFail() {
        versionCheck.setEndDate(LocalDate.of(2023,12,6));
        versionCheck.getBootcamp().setIdBootcamp(11);

        Assertions.assertThrows(ValidationErrorHandler.class, ()->this.versionCase.save(versionCheck));
    }

    @Test
    @DisplayName("retornar una lista de versiones")
    void getAll() {
        List<Version> versionList = GetObjectVersion.getListVersion();

        when(this.versionPersistencePort.getAll(0,10,"version", false)).thenReturn(versionList);

        final List<Version> result = this.versionCase.getAll(0,10,"version", false, 0 );

        Assertions.assertEquals(versionList, result);
    }

    @Test
    @DisplayName("retornar una lista de versiones filtradas por un bootcamp especifico")
    void getAllFilter() {
        List<Version> versionList = GetObjectVersion.getListVersion();

        when(this.versionPersistencePort.getAll(0,10,"version", false)).thenReturn(versionList);

        final List<Version> result = this.versionCase.getAll(0,10,"version", false, 10 );
        Assertions.assertNotEquals(versionList, result);

    }
}