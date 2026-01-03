package com.medical.cabinet.mapper;

import com.medical.cabinet.domain.Appointment;
import com.medical.cabinet.dto.AppointmentDto;

public interface AppointmentMapper {

    static AppointmentDto fromAppointment(Appointment appointment){
        return new AppointmentDto(
                appointment.getId(),
                DoctorMapper.fromDoctor(appointment.getDoctor()),
                SlotMapper.fromSlot(appointment.getSlot()),
                appointment.getPatientName(),
                appointment.getCreatedAt()
        );
    }

}
