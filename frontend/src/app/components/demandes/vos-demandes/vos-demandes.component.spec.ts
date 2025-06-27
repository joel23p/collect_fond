import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VosDemandesComponent } from './vos-demandes.component';

describe('VosDemandesComponent', () => {
  let component: VosDemandesComponent;
  let fixture: ComponentFixture<VosDemandesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VosDemandesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VosDemandesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
