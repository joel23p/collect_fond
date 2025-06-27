import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContributionsCardsComponent } from './contributions-cards.component';

describe('ContributionsCardsComponent', () => {
  let component: ContributionsCardsComponent;
  let fixture: ComponentFixture<ContributionsCardsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContributionsCardsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ContributionsCardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
