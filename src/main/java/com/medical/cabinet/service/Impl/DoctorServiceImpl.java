package com.medical.cabinet.service.Impl;

import com.medical.cabinet.domain.Doctor;
import com.medical.cabinet.dto.DoctorDto;
import com.medical.cabinet.dto.PageResponse;
import com.medical.cabinet.mapper.DoctorMapper;
import com.medical.cabinet.repository.DoctorRepository;
import com.medical.cabinet.service.IDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements IDoctorService {

    private final DoctorRepository repository;

    @Override
    public PageResponse<DoctorDto> findAll(int page, int size) {
        int pageOneBased = Math.max(1, page);
        Pageable pageable = PageRequest.of(pageOneBased - 1, size, Sort.by("id").descending());
        Page<Doctor> doctorPages = repository.findAll(pageable);
        List<DoctorDto> elements = doctorPages.getContent().stream()
                .map(DoctorMapper::fromDoctor)
                .toList();
        return new PageResponse<>(
                elements,
                doctorPages.getNumber(),
                doctorPages.getSize(),
                doctorPages.getTotalElements(),
                doctorPages.getTotalPages()
        );

    }

}
