import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

// This means that the service will be provided in the root module, which is the AppModule. 
@Injectable({
  providedIn: 'root'
})
export class ProductService{
  private apiServerUrl = ''; // This is blank because we are using a proxy to connect to the backend server. A proxy is what sits between the client and the server which is used to forward requests to the server.

  constructor(private http: HttpClient){} // Injecting the HttpClient service into the ProductService class.

  // This method will make an HTTP GET request to the backend server to retrieve all the products.
  public getEmployees(): Observable<Product[]>{
    return this.http.get<Product[]>(`${this.apiServerUrl}/product/all`);
  }

}