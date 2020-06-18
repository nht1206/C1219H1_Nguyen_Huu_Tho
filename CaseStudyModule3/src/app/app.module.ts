import { ApiUrl } from './config/api-url';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarMenuComponent } from './components/sidebar-menu/sidebar-menu.component';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [AppComponent, SidebarMenuComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [
    {
      provide: ApiUrl,
      useValue: 'http://localhost:3000',
    },
    {
      provide: 'SIZE',
      useValue: 10,
    },
    DatePipe,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
