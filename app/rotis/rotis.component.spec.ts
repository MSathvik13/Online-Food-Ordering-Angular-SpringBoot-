import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RotisComponent } from './rotis.component';

describe('RotisComponent', () => {
  let component: RotisComponent;
  let fixture: ComponentFixture<RotisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RotisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RotisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
