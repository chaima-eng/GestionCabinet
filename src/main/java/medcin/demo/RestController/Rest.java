package medcin.demo.RestController;

import medcin.demo.Entity.Clinique;
import medcin.demo.Entity.Medcin;
import medcin.demo.Entity.Patient;
import medcin.demo.Entity.RendezVous;
import medcin.demo.Service.IntMedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Rest")
public class Rest {
    @Autowired
    private IntMedService Myservice;
    @PostMapping("/AjouterC")
    public Clinique addClinique(@RequestBody Clinique clinique)
    {
        return Myservice.addClinique(clinique);
    }

    @PostMapping("/AjouterEtAffecter/{id-C}")
    @ResponseBody
    public Medcin addMedAndAssignToClinique(@RequestBody Medcin medcin,@PathVariable("id-C") Long cliniqueId)
    {
     return Myservice.addMedAndAssignToClinique(medcin,cliniqueId);
    }

    @PostMapping("/AjouterP")
    public Patient addPatient(@RequestBody Patient patient)
    {
        return Myservice.addPatient(patient);

    }

    @PostMapping("/AjouterRDV/{idMed}/{idPa}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv,@PathVariable("idMed") Long idMedcin,@PathVariable("idPa") Long idPatient)
    {
       Myservice.addRDVAndAssignMedAndPatient(rdv,idMedcin,idPatient);
    }


    @GetMapping("/get/{id}")
    public int getNbrRendezVousMedcin(@PathVariable("id") Long idMedcin)
    {
        return Myservice.getNbrRendezVousMedcin(idMedcin);
    }


}
