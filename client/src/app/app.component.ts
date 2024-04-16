import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Product } from './product';
import { ProductService } from './product.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  public products: Product[] = [];

  constructor(private productService: ProductService){}

  public getProduct(): void{
    this.productService.getProduct().subscribe({
      next: (response: Product[]) => { this.products = response; }, // when the response is received, the products array is updated with the response.
      error: (error: HttpErrorResponse) => { alert(error.message); },
      complete: () => { console.log('Completed'); }
  });
  }
}
