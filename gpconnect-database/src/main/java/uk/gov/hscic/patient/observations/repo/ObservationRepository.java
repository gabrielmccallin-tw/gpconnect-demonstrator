package uk.gov.hscic.patient.observations.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.gov.hscic.patient.observations.model.ObservationEntity;
import uk.gov.hscic.patient.problems.model.ProblemEntity;

public interface ObservationRepository extends JpaRepository<ObservationEntity, Long> {
    
    List<ObservationEntity> findBynhsNumber(String patientId);

}
