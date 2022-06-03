package medcin.demo.Repository;

import medcin.demo.Entity.RendezVous;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntRendezVousRepo extends CrudRepository<RendezVous,Long> {
}
