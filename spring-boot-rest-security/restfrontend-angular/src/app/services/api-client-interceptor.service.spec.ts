import { TestBed } from '@angular/core/testing';

import { ApiClientInterceptorService } from './api-client-interceptor.service';

describe('ApiClientInterceptorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApiClientInterceptorService = TestBed.get(ApiClientInterceptorService);
    expect(service).toBeTruthy();
  });
});
