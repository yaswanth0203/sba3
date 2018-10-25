import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccessCustomerComponent } from './success-customer.component';

describe('SuccessCustomerComponent', () => {
  let component: SuccessCustomerComponent;
  let fixture: ComponentFixture<SuccessCustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuccessCustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuccessCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
