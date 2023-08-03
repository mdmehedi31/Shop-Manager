import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateStockinComponent } from './update-stockin.component';

describe('UpdateStockinComponent', () => {
  let component: UpdateStockinComponent;
  let fixture: ComponentFixture<UpdateStockinComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateStockinComponent]
    });
    fixture = TestBed.createComponent(UpdateStockinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
