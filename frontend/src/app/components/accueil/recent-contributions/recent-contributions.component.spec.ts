import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecentContributionsComponent } from './recent-contributions.component';

describe('RecentContributionsComponent', () => {
  let component: RecentContributionsComponent;
  let fixture: ComponentFixture<RecentContributionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecentContributionsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RecentContributionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
