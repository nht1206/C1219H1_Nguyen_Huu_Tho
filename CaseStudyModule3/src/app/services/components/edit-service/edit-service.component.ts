import { Service } from './../../../models/service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ServiceService } from 'src/app/app-services/service.service';

@Component({
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.css'],
})
export class EditServiceComponent implements OnInit {
  inputForm: FormGroup;
  service: Service;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private serviceService: ServiceService,
    private route: ActivatedRoute
  ) {}
  ngOnInit(): void {
    const id = parseInt(this.route.snapshot.paramMap.get('id'), 10);
    if (isNaN(id)) {
      this.router.navigateByUrl('services');
      return;
    }
    this.service = this.serviceService.getServiceById(id);
    this.inputForm = this.formBuilder.group({
      code: [
        this.service.code,
        [Validators.required, Validators.pattern('^DV-[0-9]{4}')],
      ],
      serviceName: [this.service.serviceName, [Validators.required]],
      area: [
        this.service.area,
        [Validators.min(1), Validators.max(500), Validators.required],
      ],
      numberOfFloor: [
        this.service.numberOfFloor,
        [Validators.min(1), Validators.max(16), Validators.required],
      ],
      maxNumberOfPeople: [
        this.service.maxNumberOfPeople,
        [Validators.required, Validators.min(1)],
      ],
      price: [
        parseInt(this.service.price.replace('$', ''), 10),
        [Validators.required, Validators.min(1)],
      ],
      status: [
        this.service.status,
        [Validators.required, Validators.pattern('(on|off)')],
      ],
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
