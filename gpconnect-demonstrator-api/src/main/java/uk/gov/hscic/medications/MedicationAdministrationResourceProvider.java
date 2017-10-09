package uk.gov.hscic.medications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.MedicationAdministration;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.rest.annotation.RequiredParam;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.server.IResourceProvider;
import uk.gov.hscic.medication.administration.MedicationAdministrationSearch;
import uk.gov.hscic.model.medication.MedicationAdministrationDetail;

@Component
public class MedicationAdministrationResourceProvider  implements IResourceProvider {

    @Autowired
    private MedicationAdministrationSearch medicationAdministrationSearch;

    @Override
    public Class<MedicationAdministration> getResourceType() {
        return MedicationAdministration.class;
    }

    @Search
    public List<MedicationAdministration> getMedicationAdministrationsForPatientId(@RequiredParam(name = "patient") String patientId) {
        ArrayList<MedicationAdministration> medicationAdministrations = new ArrayList<>();

        List<MedicationAdministrationDetail> medicationAdministrationDetailList = medicationAdministrationSearch.findMedicationAdministrationForPatient(Long.parseLong(patientId));

        if (medicationAdministrationDetailList != null && !medicationAdministrationDetailList.isEmpty()) {
            for(MedicationAdministrationDetail medicationAdministrationDetail : medicationAdministrationDetailList) {
                MedicationAdministration medicationAdministration = new MedicationAdministration();
                medicationAdministration.setId(String.valueOf(medicationAdministrationDetail.getId()));
                medicationAdministration.getMeta().setLastUpdated(medicationAdministrationDetail.getLastUpdated());
                medicationAdministration.getMeta().setVersionId(String.valueOf(medicationAdministrationDetail.getLastUpdated().getTime()));
                medicationAdministration.setPatient(new ResourceReferenceDt("Patient/"+medicationAdministrationDetail.getPatientId()));
                medicationAdministration.setPractitioner(new ResourceReferenceDt("Practitioner/"+medicationAdministrationDetail.getPractitionerId()));
                medicationAdministration.setPrescription(new ResourceReferenceDt("MedicationOrder/"+medicationAdministrationDetail.getPrescriptionId()));
                medicationAdministration.setEffectiveTime(new DateTimeDt(medicationAdministrationDetail.getAdministrationDate()));
                medicationAdministration.setMedication(new ResourceReferenceDt("Medication/"+medicationAdministrationDetail.getMedicationId()));
                medicationAdministrations.add(medicationAdministration);
            }
        }

        return medicationAdministrations;
    }
}
