import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoirPlusInfosComponent } from './voir-plus-infos.component';

describe('VoirPlusInfosComponent', () => {
  let component: VoirPlusInfosComponent;
  let fixture: ComponentFixture<VoirPlusInfosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VoirPlusInfosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VoirPlusInfosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
