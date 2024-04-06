package projects.bootcamp.adapters.driven.jpa.mysql.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import projects.bootcamp.adapters.driven.jpa.mysql.entity.VersionEntity;

@Repository
public interface IVersionRepository extends JpaRepository<VersionEntity, Integer> {

}
