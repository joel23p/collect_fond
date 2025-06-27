import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeMariageComponent } from './celebration-mariage.component';

describe('DemandeMariageComponent', () => {
  let component: DemandeMariageComponent;
  let fixture: ComponentFixture<DemandeMariageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DemandeMariageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DemandeMariageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
