import { TestBed } from '@angular/core/testing';

import { RestaurantregisterService } from './restaurantregister.service';

describe('RestaurantregisterService', () => {
  let service: RestaurantregisterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestaurantregisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
