import { ApiUrl } from './../config/api-url';
import { Employee } from './../models/employee';
import { Injectable, Inject, Optional } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private employeeList: Employee[] = [];
  private filteredList: Employee[];
  private employeeListSubject: BehaviorSubject<
    Employee[]
  > = new BehaviorSubject([]);
  private lengthSubject: BehaviorSubject<number> = new BehaviorSubject(null);
  employeeList$: Observable<
    Employee[]
  > = this.employeeListSubject.asObservable();
  length$ = this.lengthSubject.asObservable();
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
    this.http.get<Employee[]>(`${this.apiUrl}/employees`).subscribe((next) => {
      this.employeeList = next;
      this.filteredList = [...this.employeeList];
      this.updateEmployeeList();
    });
  }

  getEmployeeList({ size = 10, page = 1 }) {
    const first = (page - 1) * size;
    const last = page * size - 1;
    this.filteredList = this.employeeList.filter(
      (e, i) => i >= first && i <= last
    );
    this.updateEmployeeList();
  }

  updateEmployeeList() {
    this.employeeListSubject.next(this.filteredList);
    this.lengthSubject.next(this.employeeList.length);
  }

  addEmployee(employee: Partial<Employee>) {
    this.http
      .post<Employee>(`${this.apiUrl}/employees`, employee)
      .subscribe((next) => {
        this.employeeList.push(next);
        this.getEmployeeList({});
        this.updateEmployeeList();
      });
  }

  deleteEmployee(id: number) {
    this.http.delete(`${this.apiUrl}/employees/` + id).subscribe(() => {
      this.employeeList = this.employeeList.filter((e) => id !== e.id);
      this.filteredList = this.filteredList.filter((e) => id !== e.id);
      this.updateEmployeeList();
    });
  }

  getEmployeeById(id: number): Employee {
    return this.employeeList.find((e) => id === e.id);
  }

  updateEmployee(employee: Employee) {
    this.http
      .patch<Employee>(`${this.apiUrl}/employees/` + employee.id, employee)
      .subscribe((next) => {
        this.employeeList.forEach((e, idx) => {
          if (e.id === next.id) {
            this.employeeList[idx] = next;
          }
        });
        this.getEmployeeList({});
        this.updateEmployeeList();
      });
  }

  search(keyword: string) {
    this.http
      .get<Employee[]>(`${this.apiUrl}/employees?q=${keyword}`)
      .subscribe((next) => {
        this.employeeList = next;
        this.getEmployeeList({});
        this.updateEmployeeList();
      });
  }

  getEmployeeByCode(code: string) {
    return this.employeeList.find((e) => code === e.code);
  }
}
