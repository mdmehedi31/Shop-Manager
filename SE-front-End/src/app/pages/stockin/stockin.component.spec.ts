import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockinComponent } from './stockin.component';

describe('StockinComponent', () => {
  let component: StockinComponent;
  let fixture: ComponentFixture<StockinComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StockinComponent]
    });
    fixture = TestBed.createComponent(StockinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
