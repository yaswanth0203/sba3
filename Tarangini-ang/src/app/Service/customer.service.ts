import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Http, RequestOptions, Headers, Response } from '@angular/http'; import { Plans } from '../Model/plans';
import { Customer } from '../Model/customer';
;

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  baseUrl: string;
  constructor(private http: Http) {
    this.baseUrl = "http://localhost:3131/Tarangini";
  }


  getAllPlans(): Observable<Plans[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data.json())
    );
  }

  getSearchUrl(type: string, value: number): string {
    return this.baseUrl + "/" + type + "/" + value;
  }

  searchPlans(field: string, value: number): Observable<Plans[]> {
    return this.http.get(this.getSearchUrl(field, value)).pipe(
      map(data => data.json())
    );
  }

  getJsonContentTypeHeader(): RequestOptions {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }


  addCustomer(Customer: Customer): Observable<Customer> {
    return this.http.post(this.baseUrl, JSON.stringify(Customer), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }

  

  getBaseUrlById(id: number): string {
    return this.baseUrl + "/" + id;
  }
  getCustomerByOrderNumber(id: number): Observable<Customer> {
    return this.http.get(this.getBaseUrlById(id)).pipe(
      map(data => data.json())
    );
  }
}
