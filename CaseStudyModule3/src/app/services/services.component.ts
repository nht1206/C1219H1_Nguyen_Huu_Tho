import { Observable } from 'rxjs';
import { ServiceService } from './../app-services/service.service';
import { FormBuilder } from '@angular/forms';
import { Component, OnInit, Inject } from '@angular/core';
import { Service } from '../models/service';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css'],
})
export class ServicesComponent implements OnInit {
  serviceList$: Observable<Service[]>;
  totalPages;
  currentPage = 1;
  constructor(
    private serviceService: ServiceService,
    @Inject('SIZE') private size: number
  ) {}

  ngOnInit(): void {
    this.serviceList$ = this.serviceService.serviceList$;
    this.serviceService.getServiceList({});
    this.serviceService.length$.subscribe((next) => {
      if (next % this.size === 0) {
        this.totalPages = Array(next / this.size)
          .fill(0)
          .map((x, i) => i + 1);
      } else {
        this.totalPages = Array(Math.floor(next / this.size) + 1)
          .fill(0)
          .map((x, i) => i + 1);
      }
    });
  }
  nextPage() {
    if (this.currentPage === this.totalPages.length) {
      this.currentPage = 1;
    } else {
      this.currentPage++;
    }
    this.updatePage();
  }

  previousPage() {
    if (this.currentPage === 1) {
      this.currentPage = this.totalPages.length;
    } else {
      this.currentPage--;
    }
    this.updatePage();
  }

  jumpToPage(page) {
    this.currentPage = page;
    this.updatePage();
  }

  updatePage() {
    this.serviceService.getServiceList({ page: this.currentPage });
  }

  onDelete(id: number) {
    if (confirm('Do you want to delete this service')) {
      this.serviceService.deleteService(id);
      this.updatePage();
    }
  }
}
