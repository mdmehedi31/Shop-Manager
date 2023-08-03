import { TestBed } from '@angular/core/testing';

import { AddMonthlyCostService } from './add-monthly-cost.service';

describe('AddMonthlyCostService', () => {
  let service: AddMonthlyCostService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddMonthlyCostService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
