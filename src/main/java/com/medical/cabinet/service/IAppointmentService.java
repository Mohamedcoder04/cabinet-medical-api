package com.medical.cabinet.service;

import com.medical.cabinet.dto.AppointmentRequest;

public interface IAppointmentService {
    void reserveAppointment(AppointmentRequest request);
}
