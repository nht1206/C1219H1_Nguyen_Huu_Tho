import { Employee } from './../../../models/employee';
import { EmployeeService } from 'src/app/app-services/employee.service';
import { CustomerService } from './../../../app-services/customer.service';
import { ServiceService } from 'src/app/app-services/service.service';
import { Customer } from './../../../models/customer';
import { ContractService } from './../../../app-services/contract.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Service } from 'src/app/models/service';

@Component({
  selector: 'app-create-contract',
  templateUrl: './create-contract.component.html',
  styleUrls: ['./create-contract.component.css'],
})
export class CreateContractComponent implements OnInit {
  inputForm: FormGroup;
  errorMessage = [];
  constructor(
    private formBuilder: FormBuilder,
    private datePipe: DatePipe,
    private router: Router,
    private contractService: ContractService,
    private serviceService: ServiceService,
    private customerService: CustomerService,
    private employeeService: EmployeeService
  ) {}

  ngOnInit(): void {
    this.inputForm = this.formBuilder.group({
      employeeId: [
        '',
        [Validators.required, Validators.pattern('^NV-[0-9]{4}$')],
      ],
      serviceId: [
        '',
        [Validators.required, Validators.pattern('^DV-[0-9]{4}$')],
      ],
      customerId: [
        '',
        [Validators.required, Validators.pattern('^KH-[0-9]{4}$')],
      ],
      createdOn: ['', [Validators.required]],
      endedOn: ['', [Validators.required]],
      deposit: [null, [Validators.min(1), Validators.required]],
      totalPrice: [null, [Validators.min(1), Validators.required]],
    });
  }

  onSubmit() {
    if (this.inputForm.valid) {
      this.errorMessage = [];
      const customer: Customer = this.customerService.getCustomerByCode(
        this.inputForm.value.customerId
      );
      if (!customer) {
        this.errorMessage.push('Customer is not exist.');
      }
      const employee: Employee = this.employeeService.getEmployeeByCode(
        this.inputForm.value.employeeId
      );
      if (!employee) {
        this.errorMessage.push('Service is not exist.');
      }
      const service: Service = this.serviceService.getServiceByCode(
        this.inputForm.value.serviceId
      );
      if (!service) {
        this.errorMessage.push('Service is not exist.');
      }
      if (this.errorMessage.length !== 0) {
        return;
      }
      const contract = {
        ...this.inputForm.value,
        customerId: customer.id,
        employeeId: employee.id,
        serviceId: service.id,
        createOn: this.datePipe.transform(
          new Date(this.inputForm.value.createdOn),
          'dd/MM/yyyy'
        ),
        ended: this.datePipe.transform(
          new Date(this.inputForm.value.endedOn),
          'dd/MM/yyyy'
        ),
        deposit: '$' + this.inputForm.value.deposit,
        totalPrice: '$' + this.inputForm.value.totalPrice,
      };
      this.contractService.addContract(contract);
      this.router.navigateByUrl('contracts');
    }
  }
}
