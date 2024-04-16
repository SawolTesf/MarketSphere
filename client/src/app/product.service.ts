import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'; // rxjs is a library for reactive programming using Observables, to make it easier to compose asynchronous or callback-based code.
import { Product } from './product';

// This means that the service will be provided in the root module, which is the AppModule. 
@Injectable({
  providedIn: 'root'
})
export class ProductService{
  private apiServerUrl = ''; // This is blank because we are using a proxy to connect to the backend server. A proxy is what sits between the client and the server which is used to forward requests to the server.

  constructor(private http: HttpClient){} // Injecting the HttpClient service into the ProductService class.

  // This method will make an HTTP GET request to the backend server to retrieve all the products.
  public getProduct(): Observable<Product[]>{
    return this.http.get<Product[]>(`${this.apiServerUrl}/product/all`);
  }

  public addProduct(product: Product): Observable<Product>{
    return this.http.post<Product>(`${this.apiServerUrl}/product/add`, product);
  }

  public updateProduct(product: Product): Observable<Product>{
    return this.http.put<Product>(`${this.apiServerUrl}/product/update`, product);
  }

  public deleteProduct(productId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/product/delete/${productId}`);
  }

}