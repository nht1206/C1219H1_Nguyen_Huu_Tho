import { Employee } from './../../../models/employee';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { Router, ActivatedRoute } from '@angular/router';
import { EmployeeService } from 'src/app/app-services/employee.service';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css'],
})
export class EditEmployeeComponent implements OnInit {
  inputForm: FormGroup;
  employee: Employee;
  constructor(
    private formBuilder: FormBuilder,
    private datePipe: DatePipe,
    private router: Router,
    private route: ActivatedRoute,
    private employeeService: EmployeeService
  ) {}

  ngOnInit(): void {
    const id = parseInt(this.route.snapshot.paramMap.get('id'), 10);
    if (isNaN(id)) {
      this.router.navigateByUrl('employees');
      return;
    }
    this.employee = this.employeeService.getEmployeeById(id);
    this.inputForm = this.formBuilder.group({
      code: [
        this.employee.code,
        [Validators.required, Validators.pattern('^NV-[0-9]{4}')],
      ],
      fullName: [this.employee.fullName, [Validators.required]],
      birthDay: [
        this.employee.birthDay.split('/').reverse().join('-'),
        [Validators.required],
      ],
      email: [this.employee.email, [Validators.required, Validators.email]],
      phoneNumber: [
        this.employee.phoneNumber,
        [
          Validators.required,
          Validators.pattern(
            '((09|05|03|06)+[0-9]{8})|(([(]84[)][+])+(9|5|3|7|8)+[0-9]{8})'
          ),
        ],
      ],
      address: [this.employee.address, [Validators.required]],
      identityCardNumber: [
        this.employee.identityCardNumber,
        [Validators.required, Validators.pattern('([0-9]{9}|[0-9]{12})')],
      ],
      salary: [
        parseFloat(this.employee.salary.replace('$', '')) + '',
        [Validators.required],
      ],
    });
  }
  onSubmit() {
    if (this.inputForm.valid) {
      this.employeeService.updateEmployee({
        ...this.inputForm.value,
        salary: '$' + this.inputForm.value.salary,
        birthDay: this.datePipe.transform(
          new Date(this.inputForm.value.birthDay),
          'dd/MM/yyyy'
        ),
        id: this.employee.id,
      });
      this.router.navigateByUrl('employees');
    }
  }
}
