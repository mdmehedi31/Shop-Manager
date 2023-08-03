import { TestBed } from '@angular/core/testing';

import { AddDailyCostService } from './add-daily-cost.service';

describe('AddDailyCostService', () => {
  let service: AddDailyCostService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddDailyCostService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
