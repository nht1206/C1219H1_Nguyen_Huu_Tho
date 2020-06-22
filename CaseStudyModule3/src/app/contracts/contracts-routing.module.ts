import { CreateContractDetailComponent } from './component/create-contract-detail/create-contract-detail.component';
import { EditContractComponent } from './component/edit-contract/edit-contract.component';
import { CreateContractComponent } from './component/create-contract/create-contract.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ContractsComponent } from './contracts.component';

const routes: Routes = [
  { path: '', component: ContractsComponent },
  { path: 'create', component: CreateContractComponent },
  { path: 'edit/:id', component: EditContractComponent },
  {
    path: ':id/create-contract-detail',
    component: CreateContractDetailComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ContractsRoutingModule {}
