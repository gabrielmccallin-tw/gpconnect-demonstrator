package uk.gov.hscic.appointment.slot;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.hscic.model.appointment.SlotDetail;

@Service
public class SlotSearch {
    private final SlotEntityToSlotDetailTransformer transformer = new SlotEntityToSlotDetailTransformer();

    @Autowired
    private SlotRepository slotRepository;

    public SlotDetail findSlotByID(Long id) {
        final SlotEntity item = slotRepository.findOne(id);

        return item == null
                ? null
                : transformer.transform(item);
    }

    public List<SlotDetail> findSlotsForScheduleId(Long scheduleId, Date startDate, Date endDate, Long orgId) {
    	System.out.println("LUCYLUCYLUCY: " + orgId);
        return slotRepository.findByScheduleReferenceAndEndDateTimeAfterAndStartDateTimeBeforeAndGpConnectBookableTrueAndBookableOrganizationsId(scheduleId, startDate, endDate, orgId)
                .stream()
                .filter(SlotEntity -> startDate == null || !SlotEntity.getStartDateTime().before(startDate))
                .filter(SlotEntity -> endDate == null || !SlotEntity.getStartDateTime().after(endDate))
                .map(transformer::transform)
                .collect(Collectors.toList());
    }
}
