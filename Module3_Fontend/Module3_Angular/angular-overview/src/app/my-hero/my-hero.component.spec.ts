import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyHeroComponent } from './my-hero.component';

describe('MyHeroComponent', () => {
  let component: MyHeroComponent;
  let fixture: ComponentFixture<MyHeroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyHeroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyHeroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
