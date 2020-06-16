import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LifeTimeComponent } from './life-time.component';

describe('LifeTimeComponent', () => {
  let component: LifeTimeComponent;
  let fixture: ComponentFixture<LifeTimeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LifeTimeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LifeTimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
