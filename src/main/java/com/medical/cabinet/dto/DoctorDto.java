package com.medical.cabinet.dto;

public record DoctorDto(
        Long id,
        String fullName,
        String specialty
) {
}
