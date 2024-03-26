package projects.bootcamp.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@AllArgsConstructor
@Table(name="bootcamp")
@Getter
@Setter
public class BootcampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bootcamp")
    private int idBootcamp;
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(
            name="bootcamp_capacity",
            joinColumns = @JoinColumn(name = "bootcamp_id_bootcamp"),
            inverseJoinColumns = @JoinColumn(name = "capacity_id_capacity")
    )
    private List<CapacityEntity> capacityEntityList;
}
