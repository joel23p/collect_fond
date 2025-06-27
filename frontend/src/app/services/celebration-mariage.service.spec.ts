import { TestBed } from '@angular/core/testing';

import { CelebrationMariageService } from "./celebration-mariage.service" ;

describe('DemandeMariageService', () => {
  let service: CelebrationMariageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CelebrationMariageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
