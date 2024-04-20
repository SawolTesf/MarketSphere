import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';
import { HttpErrorResponse } from '@angular/common/http';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  template: `<div *ngIf="visible">Hi</div>`, // Copied from https://angular.io/extended-diagnostics/NG8103
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  public products: Product[] = [];

  constructor(private productService: ProductService){}

  // This method is called when the component is initialized.
  ngOnInit(){
    this.getProduct();
  }

  public getProduct(): void{
    this.productService.getProduct().subscribe({
      next: (response: Product[]) => { this.products = response; }, // when the response is received, the products array is updated with the response.
      error: (error: HttpErrorResponse) => { alert(error.message); },
      complete: () => { console.log('Completed'); }
  });
  }
}
