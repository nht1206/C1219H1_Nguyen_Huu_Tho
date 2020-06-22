import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContractsRoutingModule } from './contracts-routing.module';
import { ContractsComponent } from './contracts.component';
import { CreateContractComponent } from './component/create-contract/create-contract.component';
import { EditContractComponent } from './component/edit-contract/edit-contract.component';
import { CreateContractDetailComponent } from './component/create-contract-detail/create-contract-detail.component';

@NgModule({
  declarations: [ContractsComponent, CreateContractComponent, EditContractComponent, CreateContractDetailComponent],
  imports: [
    CommonModule,
    ContractsRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class ContractsModule {}
