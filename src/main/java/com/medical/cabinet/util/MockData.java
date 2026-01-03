package com.medical.cabinet.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medical.cabinet.domain.Doctor;
import com.medical.cabinet.domain.Slot;
import com.medical.cabinet.domain.enums.SlotStatus;
import com.medical.cabinet.repository.DoctorRepository;
import com.medical.cabinet.repository.SlotRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
@Slf4j
public class MockData {

    private final DoctorRepository doctorRepository;
    private final SlotRepository slotRepository;
    private final ObjectMapper objectMapper;

    @PostConstruct
    public void loadDoctors() {
        try {
            if (doctorRepository.count() == 0) {
                InputStream inputStream = new ClassPathResource("doctors.json").getInputStream();
                List<Doctor> doctors = objectMapper.readValue(inputStream, new TypeReference<>() {
                });
                List<Slot> slots = new ArrayList<>();
                List<Integer> pauseDej = Arrays.asList(12, 13);
                for (Doctor doctor : doctors) {
                    IntStream.range(9, 16)
                            .filter(value -> !pauseDej.contains(value))
                            .forEach(value -> {
                                Slot slot = Slot.builder()
                                        .doctor(doctor)
                                        .status(SlotStatus.AVAILABLE)
                                        .startTime(prepareDate(value))
                                        .endTime(prepareDate(value + 1))
                                        .build();
                                slots.add(slot);
                            });
                }
                doctorRepository.saveAll(doctors);
                slotRepository.saveAll(slots);
                log.info("Doctors loaded successfully!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static LocalDateTime prepareDate(int i) {
        LocalDateTime currentDate = LocalDateTime.now();
        return currentDate.plusDays(1).withHour(i)
                .withMinute(0).withSecond(0).withNano(0);
    }

}
