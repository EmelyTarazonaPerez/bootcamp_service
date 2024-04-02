package projects.bootcamp.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "version")
public class VersionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_version")
    private int idVersion;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "max_capacity")
    private int cupMaxParticipant;
    @OneToMany
    @JoinColumn(name = "bootcamp_id_bootcamp")
    private List<BootcampEntity> bootcampEntityList;

}
