package com.medical.cabinet.domain;


import com.medical.cabinet.domain.enums.SlotStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"doctor_id", "startTime", "endTime"}))
public class Slot {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    private Doctor doctor;

    @Column(nullable=false)
    private LocalDateTime startTime;

    @Column(nullable=false)
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private SlotStatus status;

}

