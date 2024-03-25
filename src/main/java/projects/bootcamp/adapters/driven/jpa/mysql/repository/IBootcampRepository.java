package projects.bootcamp.adapters.driven.jpa.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;

public interface IBootcampRepository extends JpaRepository<BootcampEntity, Integer> {
}
