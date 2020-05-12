import { TestBed } from '@angular/core/testing';

import { UpdateOrderService } from './update-order.service';

describe('UpdateOrderService', () => {
  let service: UpdateOrderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateOrderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
