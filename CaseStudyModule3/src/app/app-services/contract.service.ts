import { ApiUrl } from './../config/api-url';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Contract } from './../models/contract';
import { Injectable, Inject, Optional } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ContractService {
  private contractList: Contract[] = [];
  private filteredList: Contract[];
  private contractListSubject: BehaviorSubject<
    Contract[]
  > = new BehaviorSubject([]);
  private lengthSubject: BehaviorSubject<number> = new BehaviorSubject(null);
  contractList$: Observable<
    Contract[]
  > = this.contractListSubject.asObservable();
  length$: Observable<number> = this.lengthSubject.asObservable();

  apiUrl: string;

  constructor(
    private http: HttpClient,
    @Inject(ApiUrl) @Optional() apiUrl: string
  ) {
    if (apiUrl) {
      this.apiUrl = apiUrl;
    }
  }

  fetchContractList() {
    this.http.get<Contract[]>(`${this.apiUrl}/contracts`).subscribe((next) => {
      this.contractList = next;
      this.filteredList = [...this.contractList];
      this.updateContractList();
    });
  }

  updateContractList() {
    this.contractListSubject.next(this.filteredList);
    this.lengthSubject.next(this.contractList.length);
  }

  getContractList({ size = 10, page = 1 }) {
    const first = (page - 1) * size;
    const last = page * size - 1;
    this.filteredList = this.contractList.filter(
      (c, i) => i >= first && i <= last
    );
    this.updateContractList();
  }

  addContract(contract: Partial<Contract>) {
    this.http
      .post<Contract>(`${this.apiUrl}/contracts`, contract)
      .subscribe((next) => {
        this.contractList.push(next);
        this.getContractList({});
        this.updateContractList();
      });
  }

  deleteContract(id: number) {
    this.http.delete(`${this.apiUrl}/contracts/${id}`).subscribe(() => {
      this.contractList = this.contractList.filter((c) => c.id !== id);
      this.filteredList = this.filteredList.filter((c) => c.id !== id);
      this.updateContractList();
    });
  }

  getContractById(id: number) {
    if (this.contractList.length === 0) {
      this.fetchContractList();
    }
    return this.contractList.find((c) => c.id === id);
  }

  updateContract(contract: Contract) {
    this.http
      .patch<Contract>(`${this.apiUrl}/contracts/${contract.id}`, contract)
      .subscribe((next) => {
        this.contractList.forEach((c, i) => {
          if (c.id === next.id) {
            this.contractList[i] = next;
          }
        });
        this.getContractList({});
        this.updateContractList();
      });
  }
}
