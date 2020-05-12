import { TestBed } from '@angular/core/testing';

import { DeleteOrderService } from './delete-order.service';

describe('DeleteOrderService', () => {
  let service: DeleteOrderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeleteOrderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
