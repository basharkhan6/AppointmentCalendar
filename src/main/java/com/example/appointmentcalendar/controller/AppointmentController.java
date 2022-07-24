package com.example.appointmentcalendar.controller;

import com.example.appointmentcalendar.model.Appointment;
import com.example.appointmentcalendar.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/appointments")
@CrossOrigin
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public Page<Appointment> findAll(@PageableDefault Pageable pageable) {
        return appointmentService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Appointment find(@PathVariable Long id) {
        return appointmentService.find(id);
    }

    @PostMapping
    public void create(@RequestBody @Valid Appointment appointment) {
        appointmentService.create(appointment);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid Appointment appointment) {
        appointmentService.update(id, appointment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        appointmentService.delete(id);
    }

    @GetMapping("/months/{month}")
    public Map<Integer, Set<Appointment>> findByMonth(@PathVariable int month) {
        return appointmentService.findByMonth(month);
    }

}
