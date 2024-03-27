package projects.bootcamp.adapters.driven.jpa.mysql.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface IBootcampRepository extends JpaRepository<BootcampEntity, Integer> {
    @Query("SELECT e FROM BootcampEntity e")
    Page<BootcampEntity> findAllOrderedByCapacity(Pageable pageable);
}
