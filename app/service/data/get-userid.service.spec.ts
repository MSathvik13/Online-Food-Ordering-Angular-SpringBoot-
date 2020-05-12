import { TestBed } from '@angular/core/testing';

import { GetUseridService } from './get-userid.service';

describe('GetUseridService', () => {
  let service: GetUseridService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetUseridService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
