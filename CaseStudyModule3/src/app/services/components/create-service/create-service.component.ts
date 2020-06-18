import { ServiceService } from './../../../app-services/service.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-service',
  templateUrl: './create-service.component.html',
  styleUrls: ['./create-service.component.css'],
})
export class CreateServiceComponent implements OnInit {
  inputForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private serviceService: ServiceService
  ) {}

  ngOnInit(): void {
    this.inputForm = this.formBuilder.group({
      code: ['', [Validators.required, Validators.pattern('^DV-[0-9]{4}')]],
      serviceName: ['', [Validators.required]],
      area: [
        null,
        [Validators.min(1), Validators.max(500), Validators.required],
      ],
      numberOfFloor: [
        null,
        [Validators.min(1), Validators.max(16), Validators.required],
      ],
      maxNumberOfPeople: [null, [Validators.required, Validators.min(1)]],
      price: [null, [Validators.required, Validators.min(1)]],
      status: ['', [Validators.required, Validators.pattern('(on|off)')]],
    });
  }

  onSubmit() {
    if (this.inputForm.valid) {
      this.serviceService.addService({
        ...this.inputForm.value,
        price: '$' + this.inputForm.value.price,
      });
      this.router.navigateByUrl('services');
    }
  }
}
