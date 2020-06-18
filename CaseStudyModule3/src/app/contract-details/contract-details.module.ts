import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContractDetailsRoutingModule } from './contract-details-routing.module';
import { ContractDetailsComponent } from './contract-details.component';


@NgModule({
  declarations: [ContractDetailsComponent],
  imports: [
    CommonModule,
    ContractDetailsRoutingModule
  ]
})
export class ContractDetailsModule { }
