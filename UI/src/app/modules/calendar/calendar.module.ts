import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CalendarRoutingModule } from './calendar-routing.module';
import { MonthViewComponent } from './month-view/month-view.component';


@NgModule({
  declarations: [
    MonthViewComponent
  ],
  imports: [
    CommonModule,
    CalendarRoutingModule
  ]
})
export class CalendarModule { }
