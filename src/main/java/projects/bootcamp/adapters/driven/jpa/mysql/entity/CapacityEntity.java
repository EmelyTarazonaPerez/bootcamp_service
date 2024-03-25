package projects.bootcamp.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projects.bootcamp.domain.model.Technology;

import java.util.List;

@Entity
@Table(name = "capacity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CapacityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_capacity")
    private int idCapacity;
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "technological_capacity",
            joinColumns = @JoinColumn(name = "capacity_id_capacity"),
            inverseJoinColumns = @JoinColumn(name = "technology_id_technology")
    )
    private List<TechnologyEntity> technologyEntityList;
    @ManyToMany(mappedBy = "capacityEntityList")
    private List<BootcampEntity> bootcampEntities;
}
