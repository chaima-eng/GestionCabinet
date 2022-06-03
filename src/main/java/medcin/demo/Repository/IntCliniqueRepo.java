package medcin.demo.Repository;

import medcin.demo.Entity.Clinique;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntCliniqueRepo extends CrudRepository<Clinique,Long> {
}
