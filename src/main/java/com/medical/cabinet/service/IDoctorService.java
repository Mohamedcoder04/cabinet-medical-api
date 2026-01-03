package com.medical.cabinet.service;

import com.medical.cabinet.dto.DoctorDto;
import com.medical.cabinet.dto.PageResponse;

import java.util.List;

public interface IDoctorService {
    PageResponse<DoctorDto> findAll(int page, int size);
}
