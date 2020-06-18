import { CustomerService } from './../app-services/customer.service';
import { Observable } from 'rxjs';
import { Component, OnInit, Inject } from '@angular/core';
import { Customer } from '../models/customer';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css'],
})
export class CustomersComponent implements OnInit {
  customerList$: Observable<Customer[]>;
  totalPages;
  currentPage = 1;

  constructor(
    private customerService: CustomerService,
    @Inject('SIZE') private size: number
  ) {}

  ngOnInit(): void {
    this.customerList$ = this.customerService.customerList$;
    this.customerService.getCustomerList({});
    this.customerService.length$.subscribe((next) => {
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
    this.customerService.getCustomerList({ page: this.currentPage });
  }

  onDelete(id: number) {
    if (confirm('Do you want to delete this customer?')) {
      this.customerService.deleteCustomer(id);
      this.updatePage();
    }
  }
}
