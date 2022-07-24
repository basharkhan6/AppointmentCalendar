import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';


const APP_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class CalendarService {

  constructor(private http: HttpClient) { }

  public getAppointments(month: number): Observable<any> {
    return this.http.get(APP_URL + '/appointments/months/' + month);
  }
}
