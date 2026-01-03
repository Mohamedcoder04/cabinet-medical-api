package com.medical.cabinet.dto;

import com.medical.cabinet.domain.Doctor;
import com.medical.cabinet.domain.enums.SlotStatus;

import java.time.LocalDateTime;

public record SlotDto(
        Long id,
        DoctorDto doctor,
        LocalDateTime startTime,
        LocalDateTime endTime,
        SlotStatus status
) {
}
