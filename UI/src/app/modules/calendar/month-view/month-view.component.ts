import { Component, OnInit } from '@angular/core';
import { Appointment } from '../../../shared/interfaces/appointment';
import { CalendarService } from '../calendar.service';

@Component({
  selector: 'app-month-view',
  templateUrl: './month-view.component.html',
  styleUrls: ['./month-view.component.scss']
})
export class MonthViewComponent implements OnInit {

  public appointmentsData: Map<number, Appointment[]> = new Map();


  constructor(private calendarService: CalendarService) { }

  ngOnInit(): void {
    this.getAppointments(7);
  }

  getAppointments(month: number) {
    this.calendarService.getAppointments(month).subscribe({
      next: data => Object.entries(data).forEach(([key, value]) => this.appointmentsData.set(Number(key), value as Appointment[])),
      error: () => alert('Err in loading data')
    });
  }

}
