import { CustomerService } from './app-services/customer.service';
import { EmployeeService } from './app-services/employee.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Furama resort';
  /**
   *
   */
  constructor(
    private employeeService: EmployeeService,
    private customerService: CustomerService
  ) {
    this.employeeService.fetchEmployeeList();
    customerService.fetchCustomerList();
  }
}
