import { EditServiceComponent } from './components/edit-service/edit-service.component';
import { CreateServiceComponent } from './components/create-service/create-service.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ServicesComponent } from './services.component';

const routes: Routes = [
  { path: '', component: ServicesComponent },
  { path: 'create', component: CreateServiceComponent },
  { path: 'edit/:id', component: EditServiceComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ServicesRoutingModule {}
