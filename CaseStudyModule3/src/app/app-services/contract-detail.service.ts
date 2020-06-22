import { BehaviorSubject, Observable } from 'rxjs';
import { Injectable, Inject, Optional } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiUrl } from '../config/api-url';
import { ContractDetails } from '../models/contract-details';

@Injectable({
  providedIn: 'root',
})
export class ContractDetailsService {
  private contractDetailList: ContractDetails[] = [];
  private filteredList: ContractDetails[];
  private contractDetailListSubject: BehaviorSubject<
    ContractDetails[]
  > = new BehaviorSubject([]);
  private lengthSubject: BehaviorSubject<number> = new BehaviorSubject(null);
  contractDetailsDetailList$: Observable<
    ContractDetails[]
  > = this.contractDetailListSubject.asObservable();
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
  fetchContractDetailList() {
    this.http
      .get<ContractDetails[]>(`${this.apiUrl}/contractDetails`)
      .subscribe((next) => {
        this.contractDetailList = next;
        this.filteredList = [...this.contractDetailList];
        this.updateContractDetailList();
      });
  }

  updateContractDetailList() {
    this.contractDetailListSubject.next(this.filteredList);
    this.lengthSubject.next(this.contractDetailList.length);
  }

  getContractDetailList({ size = 10, page = 1 }) {
    const first = (page - 1) * size;
    const last = page * size - 1;
    this.filteredList = this.contractDetailList.filter(
      (c, i) => i >= first && i <= last
    );
    this.updateContractDetailList();
  }

  getContractDetailListByContract(contractId: number) {
    this.filteredList = this.contractDetailList.filter(
      (c) => c.contractId === contractId
    );
    this.updateContractDetailList();
  }

  addContractDetails(contractDetails: Partial<ContractDetails>) {
    this.http
      .post<ContractDetails>(`${this.apiUrl}/contractDetails`, contractDetails)
      .subscribe((next) => {
        this.contractDetailList.push(next);
        this.getContractDetailList({});
        this.updateContractDetailList();
      });
  }

  deleteContractDetails(id: number) {
    this.http.delete(`${this.apiUrl}/contractDetails/${id}`).subscribe(() => {
      this.contractDetailList = this.contractDetailList.filter(
        (c) => c.id !== id
      );
      this.filteredList = this.filteredList.filter((c) => c.id !== id);
      this.updateContractDetailList();
    });
  }

  getContractDetailsById(id: number) {
    if (this.contractDetailList.length === 0) {
      this.fetchContractDetailList();
    }
    return this.contractDetailList.find((c) => c.id === id);
  }

  updateContractDetails(contractDetails: ContractDetails) {
    this.http
      .patch<ContractDetails>(
        `${this.apiUrl}/contractDetails/${contractDetails.id}`,
        contractDetails
      )
      .subscribe((next) => {
        this.contractDetailList.forEach((c, i) => {
          if (c.id === next.id) {
            this.contractDetailList[i] = next;
          }
        });
        this.getContractDetailList({});
        this.updateContractDetailList();
      });
  }

  search(keyword: string) {
    this.http
      .get<ContractDetails[]>(`${this.apiUrl}/contractDetails?q=${keyword}`)
      .subscribe((next) => {
        this.contractDetailList = next;
        this.getContractDetailList({});
        this.updateContractDetailList();
      });
  }
}
