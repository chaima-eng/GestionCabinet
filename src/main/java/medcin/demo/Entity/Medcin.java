package medcin.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Medcin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedcin;
    private String nom;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @JsonIgnore
    @ManyToMany(mappedBy = "medcins")
    private Set<Clinique> cliniques;
    @JsonIgnore
    @OneToMany(mappedBy = "medcin")
    private Set<RendezVous> rendezVous;
}
