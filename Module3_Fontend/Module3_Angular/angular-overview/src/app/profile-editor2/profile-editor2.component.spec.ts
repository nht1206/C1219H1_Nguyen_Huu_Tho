import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileEditor2Component } from './profile-editor2.component';

describe('ProfileEditor2Component', () => {
  let component: ProfileEditor2Component;
  let fixture: ComponentFixture<ProfileEditor2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileEditor2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileEditor2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
