package com.medical.cabinet.service.Impl;


import com.medical.cabinet.domain.Appointment;
import com.medical.cabinet.domain.Doctor;
import com.medical.cabinet.domain.Slot;
import com.medical.cabinet.domain.enums.SlotStatus;
import com.medical.cabinet.dto.AppointmentDto;
import com.medical.cabinet.dto.AppointmentRequest;
import com.medical.cabinet.dto.DoctorDto;
import com.medical.cabinet.dto.SlotDto;
import com.medical.cabinet.exception.InvalidOperationException;
import com.medical.cabinet.mapper.AppointmentMapper;
import com.medical.cabinet.repository.AppointmentRepository;
import com.medical.cabinet.repository.DoctorRepository;
import com.medical.cabinet.repository.SlotRepository;
import com.medical.cabinet.service.IAppointmentService;
import com.medical.cabinet.service.IDoctorService;
import com.medical.cabinet.service.ISlotService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.medical.cabinet.util.Constants.*;

@Service
@Transactional
@RequiredArgsConstructor
public class AppointmentServiceImpl implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final SlotRepository slotRepository;

    @Override
    @Transactional
    public void reserveAppointment(AppointmentRequest request) {
        var doctor = doctorRepository.findById(request.doctorId())
                .orElseThrow(() -> new EntityNotFoundException(DOCTOR_NOT_FOUND));
        var slot = slotRepository.findById(request.slotId())
                .orElseThrow(() -> new EntityNotFoundException(SLOT_NOT_FOUND));
        if (!slot.getDoctor().getId().equals(doctor.getId())) {
            throw new InvalidOperationException(SLOT_NOT_ASSOCIATED_WITH_DOCTOR);
        }

        if (slot.getStartTime().isBefore(LocalDateTime.now())) {
            throw new InvalidOperationException(SLOT_ALREADY_PASSED);
        }

        if (slot.getStatus() != SlotStatus.AVAILABLE) {
            throw new InvalidOperationException(SLOT_ALREADY_RESERVED);
        }

        slot.setStatus(SlotStatus.RESERVED);
        slotRepository.save(slot);

        var appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setSlot(slot);
        appointment.setPatientName(request.patientName());
        appointment.setCreatedAt(LocalDateTime.now());
        appointmentRepository.save(appointment);
    }

}

