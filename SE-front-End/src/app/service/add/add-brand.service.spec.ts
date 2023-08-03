import { TestBed } from '@angular/core/testing';

import { AddBrandService } from './add-brand.service';

describe('AddBrandService', () => {
  let service: AddBrandService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddBrandService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
