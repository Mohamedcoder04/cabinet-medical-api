package com.medical.cabinet.repository;

import com.medical.cabinet.domain.Slot;
import com.medical.cabinet.domain.enums.SlotStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

    @Query("select s from Slot s where s.doctor.id = :doctorId and s.status = :status")
    Page<Slot> findByDoctorAndStatus(Pageable pageable, @Param("doctorId") Long doctorId, @Param("status") SlotStatus status);

}
