import { Contract } from './../../../models/contract';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { Router, ActivatedRoute } from '@angular/router';
import { ContractService } from 'src/app/app-services/contract.service';
import { ServiceService } from 'src/app/app-services/service.service';
import { CustomerService } from 'src/app/app-services/customer.service';
import { EmployeeService } from 'src/app/app-services/employee.service';
import { Customer } from 'src/app/models/customer';
import { Employee } from 'src/app/models/employee';
import { Service } from 'src/app/models/service';

@Component({
  selector: 'app-edit-contract',
  templateUrl: './edit-contract.component.html',
  styleUrls: ['./edit-contract.component.css'],
})
export class EditContractComponent implements OnInit {
  inputForm: FormGroup;
  errorMessage = [];
  contract: Contract;

  constructor(
    private formBuilder: FormBuilder,
    private datePipe: DatePipe,
    private router: Router,
    private route: ActivatedRoute,
    private contractService: ContractService,
    private serviceService: ServiceService,
    private customerService: CustomerService,
    private employeeService: EmployeeService
  ) {}

  ngOnInit(): void {
    const id = parseInt(this.route.snapshot.paramMap.get('id'), 10);
    if (isNaN(id)) {
      this.router.navigateByUrl('contracts');
      return;
    }
    this.contract = this.contractService.getContractById(id);
    const customer: Customer = this.customerService.getCustomerById(
      this.contract.customerId
    );
    const employee: Employee = this.employeeService.getEmployeeById(
      this.contract.employeeId
    );
    const service: Service = this.serviceService.getServiceById(
      this.contract.serviceId
    );
    this.inputForm = this.formBuilder.group({
      employeeId: [
        employee.code,
        [Validators.required, Validators.pattern('^NV-[0-9]{4}$')],
      ],
      serviceId: [
        service.code,
        [Validators.required, Validators.pattern('^DV-[0-9]{4}$')],
      ],
      customerId: [
        customer.code,
        [Validators.required, Validators.pattern('^KH-[0-9]{4}$')],
      ],
      createdOn: [
        this.contract.createdOn.split('/').reverse().join('-'),
        [Validators.required],
      ],
      endedOn: [
        this.contract.endedOn.split('/').reverse().join('-'),
        [Validators.required],
      ],
      deposit: [
        parseInt(this.contract.deposit.replace('$', ''), 10),
        [Validators.min(1), Validators.required],
      ],
      totalPrice: [
        parseInt(this.contract.totalPrice.replace('$', ''), 10),
        [Validators.min(1), Validators.required],
      ],
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
        id: this.contract.id,
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
      this.contractService.updateContract(contract);
      this.router.navigateByUrl('contracts');
    }
  }
}
