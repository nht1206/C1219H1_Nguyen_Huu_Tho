import { Observable } from 'rxjs';
import { ContractDetailsService } from './../../../app-services/contract-detail.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { ContractDetails } from 'src/app/models/contract-details';

@Component({
  selector: 'app-create-contract-detail',
  templateUrl: './create-contract-detail.component.html',
  styleUrls: ['./create-contract-detail.component.css'],
})
export class CreateContractDetailComponent implements OnInit {
  inputForm: FormGroup;
  contractDetailList$: Observable<ContractDetails[]>;
  private contractId;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private contractDetailsService: ContractDetailsService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.contractDetailList$ = this.contractDetailsService.contractDetailsDetailList$;
    this.contractId = parseInt(this.route.snapshot.paramMap.get('id'), 10);
    this.contractDetailsService.getContractDetailListByContract(
      this.contractId
    );
    if (isNaN(this.contractId)) {
      this.router.navigateByUrl('contracts');
    }
    this.inputForm = this.formBuilder.group({
      contractId: this.contractId,
      quantity: [null, [Validators.required, Validators.min(1)]],
      accompaniedService: ['', [Validators.required]],
      price: [null, [Validators.required, Validators.min(1)]],
      unit: ['', [Validators.required]],
    });
  }

  onSubmit() {
    if (this.inputForm.valid) {
      this.contractDetailsService.addContractDetails({
        ...this.inputForm.value,
        price: '$' + this.inputForm.value.price,
      });
      this.contractDetailsService.getContractDetailListByContract(
        this.contractId
      );
    }
  }

  onDelete(id: number) {
    this.contractDetailsService.deleteContractDetails(id);
  }
}
