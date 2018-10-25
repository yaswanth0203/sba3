import { Component, OnInit } from '@angular/core';
import { Plans } from '../../Model/plans';
import { CustomerService } from '../../Service/customer.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-plans',
  templateUrl: './view-plans.component.html',
  styleUrls: ['./view-plans.component.css']
})
export class ViewPlansComponent implements OnInit {

  plans: Plans[];
  constructor(private custserv: CustomerService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {

    this.activatedRoute.queryParams.subscribe(
      (params) => {
        let type = params['type'];
        let srchValue = params['srchValue'];

        if (type && srchValue) {
          this.custserv.searchPlans(type, srchValue).subscribe(
            (data) => this.plans = data,
            (err) => this.plans = undefined
          );
        } else {
          this.custserv.getAllPlans().subscribe(
            (data) => this.plans = data,
            (err) => this.plans = undefined
          );
        }
      }, (err) => this.plans = undefined
    );

  }

}
