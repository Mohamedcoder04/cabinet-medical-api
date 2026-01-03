package com.medical.cabinet.mapper;

import com.medical.cabinet.domain.Slot;
import com.medical.cabinet.dto.SlotDto;

public interface SlotMapper {

    static SlotDto fromSlot(Slot slot) {
        return new SlotDto(
                slot.getId(),
                DoctorMapper.fromDoctor(slot.getDoctor()),
                slot.getStartTime(),
                slot.getEndTime(),
                slot.getStatus()
        );
    }
}
