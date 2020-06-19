import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ServicesRoutingModule } from './services-routing.module';
import { ServicesComponent } from './services.component';
import { CreateServiceComponent } from './components/create-service/create-service.component';
import { EditServiceComponent } from './components/edit-service/edit-service.component';

@NgModule({
  declarations: [ServicesComponent, CreateServiceComponent, EditServiceComponent],
  imports: [
    CommonModule,
    ServicesRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class ServicesModule {}
