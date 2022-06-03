package medcin.demo.Service;

import lombok.extern.slf4j.Slf4j;
import medcin.demo.Entity.*;
import medcin.demo.Repository.IntCliniqueRepo;
import medcin.demo.Repository.IntMedcinRepo;
import medcin.demo.Repository.IntPatientRepo;
import medcin.demo.Repository.IntRendezVousRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class MedService implements IntMedService {
    @Autowired
    private IntCliniqueRepo MyCliniqueRepo;
    @Autowired

    private IntMedcinRepo MyMedRepo;
    @Autowired

    private IntPatientRepo MyPatientRepo;
    @Autowired

    private IntRendezVousRepo MyRendezRepo;


    @Override
    public Clinique addClinique(Clinique clinique) {
        return MyCliniqueRepo.save(clinique) ;
    }

    @Override
    @Transactional
    public Medcin addMedAndAssignToClinique(Medcin medcin, Long cliniqueId) {
        Clinique clinique= MyCliniqueRepo.findById(cliniqueId).orElse(null);
        clinique.getMedcins().add(medcin);
        return MyMedRepo.save(medcin);

    }

    @Override
    public Patient addPatient(Patient patient) {
        return MyPatientRepo.save(patient);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedcin, Long idPatient) {
        Medcin medcin =MyMedRepo.findById(idMedcin).orElse(null);
        Patient patient=MyPatientRepo.findById(idPatient).orElse(null);
        rdv.setMedcin(medcin);
        rdv.setPatient(patient);
        MyRendezRepo.save(rdv);

    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecilite(long idClinique, Specialite specialite) {
        return null;
    }

    @Override
    public int getNbrRendezVousMedcin(Long idMedcin) {
        int nb=0 ;
        for(RendezVous rendezVous:MyRendezRepo.findAll())
        {
            if (rendezVous.getMedcin().getIdMedcin()==idMedcin)
            {
                nb++;
            }
        }
        return nb;
    }

    @Override
    @Scheduled(cron = "*/30 * * * * *")
    public void retreiveRDV() {
        for(RendezVous rendezVous:MyRendezRepo.findAll())
        {
            log.info("liste des rdv"+rendezVous.getDateRDV()+"Medecin"+rendezVous.getMedcin().getNom()+"Patient"+rendezVous.getPatient().getNomPatient() );
        }
    }


}
