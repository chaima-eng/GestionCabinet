package medcin.demo.Repository;

import medcin.demo.Entity.Medcin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntMedcinRepo extends CrudRepository<Medcin,Long> {
}
