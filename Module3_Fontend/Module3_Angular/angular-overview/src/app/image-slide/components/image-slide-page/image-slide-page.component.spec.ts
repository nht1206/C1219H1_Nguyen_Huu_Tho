import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageSlidePageComponent } from './image-slide-page.component';

describe('ImageSlidePageComponent', () => {
  let component: ImageSlidePageComponent;
  let fixture: ComponentFixture<ImageSlidePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImageSlidePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageSlidePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
