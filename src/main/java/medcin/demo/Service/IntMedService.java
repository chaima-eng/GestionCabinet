package medcin.demo.Service;

import medcin.demo.Entity.*;

import java.util.List;

public interface IntMedService {

    public Clinique addClinique(Clinique clinique);
    public Medcin addMedAndAssignToClinique(Medcin medcin,Long cliniqueId);
    public Patient addPatient(Patient patient);
    public void addRDVAndAssignMedAndPatient(RendezVous rdv,Long idMedcin,Long idPatient);
    public List<RendezVous> getRendezVousByCliniqueAndSpecilite(long idClinique, Specialite specialite);
    public int getNbrRendezVousMedcin(Long idMedcin);
    public void retreiveRDV();


}
