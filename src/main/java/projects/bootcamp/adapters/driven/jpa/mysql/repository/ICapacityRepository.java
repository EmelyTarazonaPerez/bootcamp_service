package projects.bootcamp.adapters.driven.jpa.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;

import java.util.Optional;

public interface ICapacityRepository extends JpaRepository<CapacityEntity, Integer> {
    Optional<CapacityEntity> findByName (String name);

}
