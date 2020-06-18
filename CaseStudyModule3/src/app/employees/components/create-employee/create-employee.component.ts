import { EmployeeService } from './../../../app-services/employee.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css'],
})
export class CreateEmployeeComponent implements OnInit {
  inputForm: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private datePipe: DatePipe,
    private router: Router,
    private employeeService: EmployeeService
  ) {}

  ngOnInit(): void {
    this.inputForm = this.formBuilder.group({
      code: ['', [Validators.required, Validators.pattern('^NV-[0-9]{4}')]],
      fullName: ['', [Validators.required]],
      birthDay: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: [
        '',
        [
          Validators.required,
          Validators.pattern(
            '((09|05|03|06)+[0-9]{8})|(([(]84[)][+])+(9|5|3|7|8)+[0-9]{8})'
          ),
        ],
      ],
      address: ['', [Validators.required]],
      identityCardNumber: [
        '',
        [Validators.required, Validators.pattern('([0-9]{9}|[0-9]{12})')],
      ],
      salary: ['', [Validators.required]],
    });
  }

  onSubmit() {
    if (this.inputForm.valid) {
      this.employeeService.addEmployee({
        ...this.inputForm.value,
        salary: '$' + this.inputForm.value.salary,
        birthDay: this.datePipe.transform(
          new Date(this.inputForm.value.birthDay),
          'dd/MM/yyyy'
        ),
      });
      this.router.navigateByUrl('employees');
    }
  }
}
