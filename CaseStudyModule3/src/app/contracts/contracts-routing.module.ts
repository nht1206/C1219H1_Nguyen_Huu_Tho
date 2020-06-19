import { CreateContractComponent } from './component/create-contract/create-contract.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ContractsComponent } from './contracts.component';

const routes: Routes = [
  { path: '', component: ContractsComponent },
  { path: 'create', component: CreateContractComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ContractsRoutingModule {}
