package org.rippleosi.patient.transfers.model;

import java.util.Date;
import java.util.List;

public class TransferOfCareDetails {

    private String sourceId;
    private List<ProblemHeadline> problems;
    private List<MedicationHeadline> medications;
    private List<AllergyHeadline> allergies;
    private List<ContactHeadline> contacts;
    private String reasonForContact;
    private String clinicalSummary;
    private String siteFrom;
    private String siteTo;
    private Date dateOfTransfer;
    private String source;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public List<ProblemHeadline> getProblems() {
        return problems;
    }

    public void setProblems(List<ProblemHeadline> problems) {
        this.problems = problems;
    }

    public List<MedicationHeadline> getMedications() {
        return medications;
    }

    public void setMedications(List<MedicationHeadline> medications) {
        this.medications = medications;
    }

    public List<AllergyHeadline> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<AllergyHeadline> allergies) {
        this.allergies = allergies;
    }

    public List<ContactHeadline> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactHeadline> contacts) {
        this.contacts = contacts;
    }

    public String getReasonForContact() {
        return reasonForContact;
    }

    public void setReasonForContact(String reasonForContact) {
        this.reasonForContact = reasonForContact;
    }

    public String getClinicalSummary() {
        return clinicalSummary;
    }

    public void setClinicalSummary(String clinicalSummary) {
        this.clinicalSummary = clinicalSummary;
    }

    public String getSiteFrom() {
        return siteFrom;
    }

    public void setSiteFrom(String siteFrom) {
        this.siteFrom = siteFrom;
    }

    public String getSiteTo() {
        return siteTo;
    }

    public void setSiteTo(String siteTo) {
        this.siteTo = siteTo;
    }

    public Date getDateOfTransfer() {
        return dateOfTransfer;
    }

    public void setDateOfTransfer(Date dateOfTransfer) {
        this.dateOfTransfer = dateOfTransfer;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
