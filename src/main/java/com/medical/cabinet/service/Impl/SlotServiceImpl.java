package com.medical.cabinet.service.Impl;

import com.medical.cabinet.domain.Doctor;
import com.medical.cabinet.domain.Slot;
import com.medical.cabinet.domain.enums.SlotStatus;
import com.medical.cabinet.dto.PageResponse;
import com.medical.cabinet.dto.SlotDto;
import com.medical.cabinet.mapper.SlotMapper;
import com.medical.cabinet.repository.SlotRepository;
import com.medical.cabinet.service.ISlotService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SlotServiceImpl implements ISlotService {

    private final SlotRepository repository;

    @Override
    public PageResponse<SlotDto> findByDoctorAndStatus(long doctorId, int page, int size) {
        int pageOneBased = Math.max(1, page);
        Pageable pageable = PageRequest.of(pageOneBased - 1, size, Sort.by("startTime").ascending());
        Page<Slot> slotsByDoctor = repository.findByDoctorAndStatus(pageable, doctorId, SlotStatus.AVAILABLE);
        List<SlotDto> elements = slotsByDoctor.getContent().stream()
                .map(SlotMapper::fromSlot)
                .toList();
        return new PageResponse<>(
                elements,
                slotsByDoctor.getNumber(),
                slotsByDoctor.getSize(),
                slotsByDoctor.getTotalElements(),
                slotsByDoctor.getTotalPages()
        );
    }
}
