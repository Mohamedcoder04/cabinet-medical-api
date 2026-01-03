package com.medical.cabinet.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    private Doctor doctor;

    @OneToOne(optional=false, fetch = FetchType.LAZY)
    private Slot slot;

    @Column(nullable=false)
    private String patientName;

    @Column(nullable=false, updatable=false)
    private LocalDateTime createdAt;


}

