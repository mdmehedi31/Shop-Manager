import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WastedProductComponent } from './wasted-product.component';

describe('WastedProductComponent', () => {
  let component: WastedProductComponent;
  let fixture: ComponentFixture<WastedProductComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WastedProductComponent]
    });
    fixture = TestBed.createComponent(WastedProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
