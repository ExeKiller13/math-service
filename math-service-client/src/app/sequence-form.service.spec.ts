/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { SequenceFormService } from './sequence-form.service';

describe('SequenceFormService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SequenceFormService]
    });
  });

  it('should ...', inject([SequenceFormService], (service: SequenceFormService) => {
    expect(service).toBeTruthy();
  }));
});
