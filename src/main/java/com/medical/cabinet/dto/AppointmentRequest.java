package com.medical.cabinet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AppointmentRequest(
        @NotNull(message = "Doctor ID is required.")
        Long doctorId,
        @NotNull(message = "Slot ID is required.")
        Long slotId,
        @NotBlank(message = "Patient name must not be blank.")
        @Size(message = "Patient name must be at least {min} characters", min = 3)
        String patientName
) {
}
