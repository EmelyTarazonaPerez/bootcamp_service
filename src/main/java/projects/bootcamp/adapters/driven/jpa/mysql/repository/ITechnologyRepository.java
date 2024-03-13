package projects.bootcamp.adapters.driven.jpa.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;

public interface ITechnologyRepository extends JpaRepository<TechnologyEntity, Integer> {

}
