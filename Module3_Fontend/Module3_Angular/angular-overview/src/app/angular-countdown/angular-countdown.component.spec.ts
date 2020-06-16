import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularCountdownComponent } from './angular-countdown.component';

describe('AngularCountdownComponent', () => {
  let component: AngularCountdownComponent;
  let fixture: ComponentFixture<AngularCountdownComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularCountdownComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularCountdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
