import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customers',
  standalone: false,
  templateUrl: './customers.html',
  styleUrl: './customers.css',
})
export class Customers implements OnInit{
  customers:any;

  constructor(private http:HttpClient , private router: Router) {}
  ngOnInit(): void {
    this.http.get("http://localhost:8888/customer-service/api/customers").subscribe({
      next : (data) => {
        this.customers = data;
      } ,
      error : (err) => {}

    });

  }
  getBilling(c : any) {
    this.router.navigateByUrl("/billing/"+c.id);
  }

}
