import { ContractDetailsService } from './app-services/contract-detail.service';
import { ContractService } from './app-services/contract.service';
import { Router } from '@angular/router';
import { ServiceService } from './app-services/service.service';
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
  keyword = '';
  /**
   *
   */
  constructor(
    private router: Router,
    private employeeService: EmployeeService,
    private customerService: CustomerService,
    private serviceService: ServiceService,
    private contractService: ContractService,
    private contractDetailsService: ContractDetailsService
  ) {
    this.employeeService.fetchEmployeeList();
    this.customerService.fetchCustomerList();
    this.serviceService.fetchEmployeeList();
    this.contractService.fetchContractList();
    this.contractDetailsService.fetchContractDetailList();
  }

  onKeywordChange() {
    if (this.router.url === '/services') {
      this.serviceService.search(this.keyword);
    }
    if (this.router.url === '/employees') {
      this.employeeService.search(this.keyword);
    }
    if (this.router.url === '/customers') {
      this.customerService.search(this.keyword);
    }
    if (this.router.url === '/contracts') {
      this.contractService.search(this.keyword);
    }
  }
}
