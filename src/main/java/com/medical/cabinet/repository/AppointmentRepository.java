package com.medical.cabinet.repository;

import com.medical.cabinet.domain.Appointment;
import com.medical.cabinet.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
