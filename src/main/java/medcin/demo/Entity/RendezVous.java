package medcin.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class RendezVous implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRDV;
    @Temporal(TemporalType.DATE)
    private Date dateRDV;
    private String remarque;
    @JsonIgnore
    @ManyToOne
    private Medcin medcin;
    @JsonIgnore
    @ManyToOne
    private Patient patient;


}
