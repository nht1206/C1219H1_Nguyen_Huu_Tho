import { EditCustomerComponent } from './components/edit-customer/edit-customer.component';
import { CreateCustomerComponent } from './components/create-customer/create-customer.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CustomersComponent } from './customers.component';

const routes: Routes = [
  { path: '', component: CustomersComponent },
  { path: 'create', component: CreateCustomerComponent },
  { path: 'edit/:id', component: EditCustomerComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CustomersRoutingModule {}
