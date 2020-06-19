import { ApiUrl } from './../config/api-url';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Service } from './../models/service';
import { Injectable, Inject, Optional } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ServiceService {
  private serviceList: Service[] = [];
  private filteredList: Service[];
  private serviceListSubject: BehaviorSubject<Service[]> = new BehaviorSubject(
    []
  );
  private lengthSubject: BehaviorSubject<number> = new BehaviorSubject(null);
  serviceList$: Observable<Service[]> = this.serviceListSubject.asObservable();
  length$: Observable<number> = this.lengthSubject.asObservable();
  apiUrl: string;

  constructor(
    private http: HttpClient,
    @Inject(ApiUrl) @Optional() apiUrl: string
  ) {
    if (apiUrl) {
      this.apiUrl = apiUrl;
    }
  }

  fetchEmployeeList() {
    this.http.get<Service[]>(`${this.apiUrl}/services`).subscribe((next) => {
      this.serviceList = next;
      this.filteredList = [...this.serviceList];
      this.updateServiceList();
    });
  }

  private updateServiceList() {
    this.serviceListSubject.next(this.filteredList);
    this.lengthSubject.next(this.serviceList.length);
  }

  getServiceList({ size = 10, page = 1 }) {
    const first = (page - 1) * size;
    const last = page * size - 1;
    this.filteredList = this.serviceList.filter(
      (s, i) => i >= first && i <= last
    );
    this.updateServiceList();
  }

  addService(service: Partial<Service>) {
    this.http
      .post<Service>(`${this.apiUrl}/services`, service)
      .subscribe((next) => {
        this.serviceList.push(next);
        this.getServiceList({});
      });
  }

  deleteService(id: number) {
    this.http.delete(`${this.apiUrl}/services/${id}`).subscribe(() => {
      this.serviceList = this.serviceList.filter((s) => s.id !== id);
      this.filteredList = this.filteredList.filter((s) => s.id !== id);
      this.updateServiceList();
    });
  }

  getServiceById(id: number) {
    if (this.serviceList.length === 0) {
      this.fetchEmployeeList();
    }
    return this.serviceList.find((s) => s.id === id);
  }

  updateService(service: Service) {
    this.http
      .patch<Service>(`${this.apiUrl}/services/${service.id}`, service)
      .subscribe((next) => {
        this.serviceList.forEach((s, i) => {
          if (s.id === next.id) {
            this.serviceList[i] = next;
          }
        });
        this.getServiceList({});
        this.updateServiceList();
      });
  }

  search(keyword: string) {
    this.http
      .get<Service[]>(`${this.apiUrl}/services?q=${keyword}`)
      .subscribe((next) => {
        this.serviceList = next;
        this.getServiceList({});
        this.updateServiceList();
      });
  }

  getServiceByCode(code: string) {
    return this.serviceList.find((s) => code === s.code);
  }
}
