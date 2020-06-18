import { ApiUrl } from './../config/api-url';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Customer } from './../models/customer';
import { Injectable, Inject, Optional } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  private customerList: Customer[] = [];
  private filteredList: Customer[];
  private customerListSubject: BehaviorSubject<
    Customer[]
  > = new BehaviorSubject([]);
  private lengthSubject: BehaviorSubject<number> = new BehaviorSubject(null);
  customerList$: Observable<
    Customer[]
  > = this.customerListSubject.asObservable();
  length$: Observable<number> = this.lengthSubject.asObservable();
  apiUrl: string;

  constructor(
    private http: HttpClient,
    @Inject(ApiUrl) @Optional() apiUrl: string
  ) {
    this.apiUrl = apiUrl;
  }

  fetchCustomerList() {
    this.http.get<Customer[]>(`${this.apiUrl}/customers`).subscribe(
      (next) => {
        this.customerList = next;
        this.filteredList = [...this.customerList];
        this.updateCustomerList();
      },
      (error) => {
        this.customerList = [];
      }
    );
  }

  private updateCustomerList() {
    this.customerListSubject.next(this.filteredList);
    this.lengthSubject.next(this.customerList.length);
  }

  getCustomerList({ size = 10, page = 1 }) {
    const first = (page - 1) * size;
    const last = page * size - 1;
    this.filteredList = this.customerList.filter(
      (c, i) => i >= first && i <= last
    );
    this.updateCustomerList();
  }

  addCustomer(customer: Partial<Customer>) {
    this.http
      .post<Customer>(`${this.apiUrl}/customers`, customer)
      .subscribe((next) => {
        this.customerList.push(next);
        this.getCustomerList({});
        this.updateCustomerList();
      });
  }

  deleteCustomer(id: number) {
    this.http.delete(`${this.apiUrl}/customers/${id}`).subscribe(() => {
      this.customerList = this.customerList.filter((c) => c.id !== id);
      this.filteredList = this.filteredList.filter((c) => c.id !== id);
      this.updateCustomerList();
    });
  }

  getCustomerById(id: number) {
    return this.customerList.find((c) => c.id === id);
  }

  updateCustomer(customer: Customer) {
    this.http
      .patch<Customer>(`${this.apiUrl}/customers/${customer.id}`, customer)
      .subscribe((next) => {
        this.customerList.forEach((c, i) => {
          if (c.id === customer.id) {
            this.customerList[i] = next;
          }
        });
        this.getCustomerList({});
        this.updateCustomerList();
      });
  }
}
