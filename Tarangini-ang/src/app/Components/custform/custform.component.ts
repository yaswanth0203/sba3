import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../../Model/customer';
import { CustomerService } from '../../Service/customer.service';


@Component({
  selector: 'app-custform',
  templateUrl: './custform.component.html',
  styleUrls: ['./custform.component.css']
})
export class CustformComponent implements OnInit {

  customer: Customer;
  pkgId: string;
  today: Date = new Date();

  constructor(
    private activatedRoute: ActivatedRoute,
    private customerService: CustomerService,
    private router: Router
  ) { }

  ngOnInit() {
    this.customer = new Customer();
    this.activatedRoute.params.subscribe(
      (params) => {
        let pkgId = params['title'];
        if (pkgId) {
          this.pkgId = pkgId;
          this.customer.pkgId = pkgId;
          this.customer.dateOfRequest = (new Date(this.today.getFullYear(), this.today.getMonth(), this.today.getDate() + 4));
        }
      }
    );
  }




  save() {
    this.customerService.addCustomer(this.customer).subscribe(
      (data) => {
        this.router.navigateByUrl("successReport/" + data.orderNumber);
      },
      (error) => { alert("Error adding customer"); }
    );
  }

}
