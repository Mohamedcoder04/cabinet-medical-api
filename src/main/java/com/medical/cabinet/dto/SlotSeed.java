package com.medical.cabinet.dto;

public record SlotSeed(

        Long id,
        Long doctorId,
        String startTime,
        String endTime,
        String status

) {
}
