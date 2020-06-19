import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContractsRoutingModule } from './contracts-routing.module';
import { ContractsComponent } from './contracts.component';
import { CreateContractComponent } from './component/create-contract/create-contract.component';

@NgModule({
  declarations: [ContractsComponent, CreateContractComponent],
  imports: [
    CommonModule,
    ContractsRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class ContractsModule {}
