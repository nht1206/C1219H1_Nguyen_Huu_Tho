import { CustomerService } from './../../../app-services/customer.service';
import { Customer } from './../../../models/customer';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css'],
})
export class EditCustomerComponent implements OnInit {
  inputForm: FormGroup;
  customer: Customer;
  constructor(
    private formBuilder: FormBuilder,
    private datePipe: DatePipe,
    private router: Router,
    private route: ActivatedRoute,
    private customerService: CustomerService
  ) {}
  ngOnInit(): void {
    const id = parseInt(this.route.snapshot.paramMap.get('id'), 10);
    if (isNaN(id)) {
      this.router.navigateByUrl('customers');
      return;
    }
    this.customer = this.customerService.getCustomerById(id);
    this.inputForm = this.formBuilder.group({
      code: [
        this.customer.code,
        [Validators.required, Validators.pattern('^NV-[0-9]{4}')],
      ],
      fullName: [this.customer.fullName, [Validators.required]],
      birthDay: [
        this.customer.birthDay.split('/').reverse().join('-'),
        [Validators.required],
      ],
      email: [this.customer.email, [Validators.required, Validators.email]],
      phoneNumber: [
        this.customer.phoneNumber,
        [
          Validators.required,
          Validators.pattern(
            '((09|05|03|06)+[0-9]{8})|(([(]84[)][+])+(9|5|3|7|8)+[0-9]{8})'
          ),
        ],
      ],
      address: [this.customer.address, [Validators.required]],
      identityCardNumber: [
        this.customer.identityCardNumber,
        [Validators.required, Validators.pattern('([0-9]{9}|[0-9]{12})')],
      ],
    });
  }
  onSubmit() {
    if (this.inputForm.valid) {
      this.customerService.updateCustomer({
        ...this.inputForm.value,
        salary: '$' + this.inputForm.value.salary,
        birthDay: this.datePipe.transform(
          new Date(this.inputForm.value.birthDay),
          'dd/MM/yyyy'
        ),
        id: this.customer.id,
      });
      this.router.navigateByUrl('customers');
    }
  }
}
