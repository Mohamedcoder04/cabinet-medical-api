package com.medical.cabinet.web;

import com.medical.cabinet.dto.AppointmentRequest;
import com.medical.cabinet.dto.DoctorDto;
import com.medical.cabinet.dto.PageResponse;
import com.medical.cabinet.dto.SlotDto;
import com.medical.cabinet.service.IAppointmentService;
import com.medical.cabinet.service.IDoctorService;
import com.medical.cabinet.service.ISlotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/doctors")
@RequiredArgsConstructor
@RestController
@Tag(name = "Doctors", description = "Endpoints for searching and managing doctors and their availability")
public class DoctorController {

    private final IDoctorService doctorService;
    private final ISlotService slotService;
    private final IAppointmentService appointmentService;


    @Operation(
            summary = "List doctors",
            description = "Returns a paginated list of doctors. Use the `page` and `size` query parameters to control pagination."
    )
    @GetMapping
    public ResponseEntity<PageResponse<DoctorDto>> findAllDoctors(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(doctorService.findAll(page, size));
    }



    @Operation(
            summary = "List doctor slots",
            description = "Returns a paginated list of appointment slots available for a specific doctor."
    )
    @GetMapping("/{doctorId}/slots")
    public ResponseEntity<PageResponse<SlotDto>> findAllSlots(
            @PathVariable long doctorId,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size

    ) {
        return ResponseEntity.ok(slotService.findByDoctorAndStatus(doctorId, page, size));
    }


    @Operation(
            summary = "Reserve an appointment",
            description = "Creates a reservation for an appointment."
    )
    @PostMapping("/appointments")
    public ResponseEntity<Void> reserveAppointment(@Valid @RequestBody AppointmentRequest request) {
        appointmentService.reserveAppointment(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}


