import { TestBed } from '@angular/core/testing';

import { AddUserOrderService } from './add-user-order.service';

describe('AddUserOrderService', () => {
  let service: AddUserOrderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddUserOrderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
