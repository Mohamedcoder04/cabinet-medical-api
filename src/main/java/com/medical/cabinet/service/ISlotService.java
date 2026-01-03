package com.medical.cabinet.service;

import com.medical.cabinet.domain.enums.SlotStatus;
import com.medical.cabinet.dto.PageResponse;
import com.medical.cabinet.dto.SlotDto;

import java.util.List;

public interface ISlotService {
    PageResponse<SlotDto> findByDoctorAndStatus(long doctorId, int page, int size);
}
