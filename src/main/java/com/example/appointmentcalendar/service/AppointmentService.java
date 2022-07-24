package com.example.appointmentcalendar.service;

import com.example.appointmentcalendar.exception.ResourceNotFoundException;
import com.example.appointmentcalendar.model.Appointment;
import com.example.appointmentcalendar.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public Appointment find(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", id));
    }

    public Page<Appointment> findAll(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }

    public void create(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public void update(Long id, Appointment appointment) {
        appointment.setId(id);
        appointmentRepository.save(appointment);
    }

    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    public Map<Integer, Set<Appointment>> findByMonth(int month) {
        Map<Integer, Set<Appointment>> res = new HashMap<>();

        LocalDate start = LocalDate.of(2022, month, 1);
        LocalDate end = start.plusMonths(1).minusDays(1);
        List<Appointment> appointments = appointmentRepository.findAllByDateBetween(start, end);

        appointments.forEach(appointment -> {
            int day = appointment.getDate().getDayOfMonth();
            if (!res.containsKey(day)) {
                res.put(day, new HashSet<>());
            }
            res.get(day).add(appointment);
        });
        return res;
    }
}
