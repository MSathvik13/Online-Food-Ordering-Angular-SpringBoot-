import { TestBed } from '@angular/core/testing';

import { GetUserOrdersService } from './get-user-orders.service';

describe('GetUserOrdersService', () => {
  let service: GetUserOrdersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetUserOrdersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
