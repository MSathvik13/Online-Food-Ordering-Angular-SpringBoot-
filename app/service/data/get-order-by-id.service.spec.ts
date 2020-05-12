import { TestBed } from '@angular/core/testing';

import { GetOrderByIdService } from './get-order-by-id.service';

describe('GetOrderByIdService', () => {
  let service: GetOrderByIdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetOrderByIdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
