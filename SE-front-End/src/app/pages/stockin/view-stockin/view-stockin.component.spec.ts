import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewStockinComponent } from './view-stockin.component';

describe('ViewStockinComponent', () => {
  let component: ViewStockinComponent;
  let fixture: ComponentFixture<ViewStockinComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewStockinComponent]
    });
    fixture = TestBed.createComponent(ViewStockinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
