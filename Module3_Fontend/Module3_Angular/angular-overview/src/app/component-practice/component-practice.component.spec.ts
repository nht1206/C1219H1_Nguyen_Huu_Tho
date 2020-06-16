import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentPracticeComponent } from './component-practice.component';

describe('ComponentPracticeComponent', () => {
  let component: ComponentPracticeComponent;
  let fixture: ComponentFixture<ComponentPracticeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentPracticeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentPracticeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
