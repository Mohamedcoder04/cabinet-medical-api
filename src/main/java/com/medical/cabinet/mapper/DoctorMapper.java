package com.medical.cabinet.mapper;

import com.medical.cabinet.domain.Doctor;
import com.medical.cabinet.dto.DoctorDto;

public interface DoctorMapper {

    static DoctorDto fromDoctor(Doctor doctor) {
        return new DoctorDto(doctor.getId(), doctor.getFullName(), doctor.getSpecialty());
    }
}
