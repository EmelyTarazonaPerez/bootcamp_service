package projects.bootcamp.adapters.driven.jpa.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;

import java.util.Optional;

public interface ITechnologyRepository extends JpaRepository<TechnologyEntity, Integer> {
    Optional<TechnologyEntity> findByName (String name);
}
