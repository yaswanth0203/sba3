import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustformComponent } from './custform.component';

describe('CustformComponent', () => {
  let component: CustformComponent;
  let fixture: ComponentFixture<CustformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
