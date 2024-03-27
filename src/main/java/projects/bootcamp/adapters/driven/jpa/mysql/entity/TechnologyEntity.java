package projects.bootcamp.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name="technology")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TechnologyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_technology")
    private int idTechnology;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "technologyList")
    private List<CapacityEntity> capacityEntityList;
}
