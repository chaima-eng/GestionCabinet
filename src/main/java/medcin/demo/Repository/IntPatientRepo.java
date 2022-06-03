package medcin.demo.Repository;

import medcin.demo.Entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntPatientRepo extends CrudRepository<Patient,Long> {
}
