import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-products',
  standalone: false,
  templateUrl: './products.html',
  styleUrl: './products.css',
})
export class Products implements OnInit {
  products: any;

  constructor(private http: HttpClient) { }
  ngOnInit(): void {
    this.http.get("http://localhost:8888/inventory-service/api/products").subscribe({
      next: (data) => {
        this.products = data;
      },
      error: (err) => { }

    })
  }

}
