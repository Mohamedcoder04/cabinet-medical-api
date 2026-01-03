package com.medical.cabinet.dto;

import com.medical.cabinet.domain.Doctor;
import com.medical.cabinet.domain.Slot;

import java.time.LocalDateTime;

public record AppointmentDto(
        Long id,
        DoctorDto doctor,
        SlotDto slot,
        String patientName,
        LocalDateTime createdAt
) {
}
