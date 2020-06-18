import { CustomerService } from './../../../app-services/customer.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css'],
})
export class CreateCustomerComponent implements OnInit {
  inputForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private datePipe: DatePipe,
    private router: Router,
    private customerService: CustomerService
  ) {}

  ngOnInit(): void {
    this.inputForm = this.formBuilder.group({
      code: ['', [Validators.required, Validators.pattern('^KH-[0-9]{4}')]],
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
    });
  }
  onSubmit() {
    if (this.inputForm.valid) {
      this.customerService.addCustomer({
        ...this.inputForm.value,
        birthday: this.datePipe.transform(
          new Date(this.inputForm.value.birthDay),
          'dd/MM/yyyy'
        ),
      });
      this.router.navigateByUrl('customers');
    }
  }
}
