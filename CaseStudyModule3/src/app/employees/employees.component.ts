import { Observable, range } from 'rxjs';
import { EmployeeService } from './../app-services/employee.service';
import { Component, OnInit, Inject } from '@angular/core';
import { Employee } from '../models/employee';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css'],
})
export class EmployeesComponent implements OnInit {
  employeeList$: Observable<Employee[]>;
  totalPages;
  currentPage = 1;
  constructor(
    private employeeService: EmployeeService,
    @Inject('SIZE') private size: number
  ) {}

  ngOnInit(): void {
    this.employeeService.getEmployeeList({});
    this.employeeList$ = this.employeeService.employeeList$;
    this.employeeService.length$.subscribe((next) => {
      if (next % this.size === 0) {
        this.totalPages = Array(next / this.size)
          .fill(0)
          .map((x, i) => i + 1);
      } else {
        this.totalPages = Array(Math.floor(next / this.size) + 1)
          .fill(0)
          .map((x, i) => i + 1);
      }
    });
  }

  nextPage() {
    if (this.currentPage === this.totalPages.length) {
      this.currentPage = 1;
    } else {
      this.currentPage++;
    }
    this.updatePage();
  }

  previousPage() {
    if (this.currentPage === 1) {
      this.currentPage = this.totalPages.length;
    } else {
      this.currentPage--;
    }
    this.updatePage();
  }

  jumpToPage(page) {
    this.currentPage = page;
    this.updatePage();
  }

  updatePage() {
    this.employeeService.getEmployeeList({ page: this.currentPage });
  }

  onDelete(id: number) {
    if (confirm('Do you want to delete this employee?')) {
      this.employeeService.deleteEmployee(id);
      this.updatePage();
    }
  }
}
