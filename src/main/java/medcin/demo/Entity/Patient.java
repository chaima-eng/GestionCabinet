package medcin.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private String nomPatient;
    private int Telephone;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
     @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private Set<RendezVous> rendezVous;




}
