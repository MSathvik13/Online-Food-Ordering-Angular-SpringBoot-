import { TestBed } from '@angular/core/testing';

import { GetUserTotalAmountService } from './get-user-total-amount.service';

describe('GetUserTotalAmountService', () => {
  let service: GetUserTotalAmountService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetUserTotalAmountService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
