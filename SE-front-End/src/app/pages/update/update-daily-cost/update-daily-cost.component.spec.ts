import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDailyCostComponent } from './update-daily-cost.component';

describe('UpdateDailyCostComponent', () => {
  let component: UpdateDailyCostComponent;
  let fixture: ComponentFixture<UpdateDailyCostComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateDailyCostComponent]
    });
    fixture = TestBed.createComponent(UpdateDailyCostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
