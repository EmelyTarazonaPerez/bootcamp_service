package projects.bootcamp.adapters.driven.jpa.mysql.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.VersionEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import projects.bootcamp.adapters.driven.jpa.mysql.mapper.IVersionEntityMapper;
import projects.bootcamp.adapters.driven.jpa.mysql.repository.IVersionRepository;
import projects.bootcamp.contants.GetObjectVersion;
import projects.bootcamp.domain.model.Version;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VersionAdapterTest {
    @Mock
    private IVersionEntityMapper versionEntityMapper;
    @Mock
    private IVersionRepository versionRepository;
    @InjectMocks
    private VersionAdapter versionAdapter;

    @Test
    @DisplayName("retornar una version si se guarda correctamente en la BD")
    void save() {
        Version version = GetObjectVersion.getVersion();
        when(versionEntityMapper.toVersion(versionRepository.save(
                versionEntityMapper.toVersionEntity(version)))).thenReturn(version);

        final Version result = versionAdapter.save(version);
        Assertions.assertEquals(version, result);
    }

    @Test
    @DisplayName("retornar una exception cuando se quiera guardar una version que ya existe en la BD")
    void saveErrorBD() {
        Version version = GetObjectVersion.getVersion();
        when(versionEntityMapper.toVersion(versionRepository.save(
                versionEntityMapper.toVersionEntity(version)))).thenThrow(new ProductAlreadyExistsException("error"));

        Assertions.assertThrows(ProductAlreadyExistsException.class, ()-> versionAdapter.save(version));
        Mockito.verify(versionRepository, Mockito.times(2)).save(any());

    }

    @Test
    void getAll() {
        List<Version> versions = GetObjectVersion.getListVersion();
        Page<VersionEntity> versionEntities = GetObjectVersion.getPageVersionEntity();

        when(versionRepository.findAll(any(Pageable.class))).thenReturn(versionEntities);
        when(versionEntityMapper.toListVersion(versionEntities)).thenReturn(versions);

        final List<Version> result = versionAdapter.getAll(0,10, "version", false);
        Assertions.assertEquals(versions, result);
        assertNotNull(result);
    }
}