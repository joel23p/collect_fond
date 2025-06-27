import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MembreStatsComponent } from './membre-stats.component';

describe('MembreStatsComponent', () => {
  let component: MembreStatsComponent;
  let fixture: ComponentFixture<MembreStatsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MembreStatsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MembreStatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
