package com.example.appointmentcalendar.repository;

import com.example.appointmentcalendar.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByDateBetween(LocalDate start, LocalDate end);

}
