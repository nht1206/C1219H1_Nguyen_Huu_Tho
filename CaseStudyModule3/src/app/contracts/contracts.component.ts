import { ContractService } from './../app-services/contract.service';
import { Observable } from 'rxjs';
import { Component, OnInit, Inject } from '@angular/core';
import { Contract } from '../models/contract';
import { ServiceService } from '../app-services/service.service';
import { CustomerService } from '../app-services/customer.service';
import { EmployeeService } from '../app-services/employee.service';

@Component({
  selector: 'app-contracts',
  templateUrl: './contracts.component.html',
  styleUrls: ['./contracts.component.css'],
})
export class ContractsComponent implements OnInit {
  contractList$: Observable<Contract[]>;
  totalPages;
  currentPage = 1;

  constructor(
    private contractService: ContractService,
    private employeeService: EmployeeService,
    private customerService: CustomerService,
    private serviceService: ServiceService,
    @Inject('SIZE') private size: number
  ) {}

  ngOnInit(): void {
    this.contractList$ = this.contractService.contractList$;
    this.contractService.getContractList({ page: this.currentPage });
    this.contractService.length$.subscribe((next) => {
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

  getCustomerCode(id: number) {
    return this.customerService.getCustomerById(id).code;
  }

  getEmployeeCode(id: number) {
    return this.employeeService.getEmployeeById(id).code;
  }

  getServiceCode(id: number) {
    return this.serviceService.getServiceById(id).code;
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
    this.contractService.getContractList({ page: this.currentPage });
  }

  onDelete(id: number) {
    if (confirm('Do you want to delete this service')) {
      this.contractService.deleteContract(id);
      this.updatePage();
    }
  }
}
