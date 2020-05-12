import { TestBed } from '@angular/core/testing';

import { GetUsernameService } from './get-username.service';

describe('GetUsernameService', () => {
  let service: GetUsernameService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetUsernameService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
