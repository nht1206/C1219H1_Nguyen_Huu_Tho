import { ImageSlideComponent } from './../image-slide/image-slide.component';
import {
  Component,
  OnInit,
  ContentChildren,
  QueryList,
  AfterContentInit,
  ChangeDetectorRef,
  AfterViewChecked,
} from '@angular/core';
import { ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-image-slider',
  templateUrl: './image-slider.component.html',
  styleUrls: ['./image-slider.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class ImageSliderComponent
  implements OnInit, AfterContentInit, AfterViewChecked {
  @ContentChildren(ImageSlideComponent) slides: QueryList<ImageSlideComponent>;

  component;

  activeIndex = 0;

  constructor(private cdr: ChangeDetectorRef) {}
  ngOnInit(): void {}

  ngAfterContentInit(): void {
    this.component = this.slides.first;
  }

  ngAfterViewChecked() {
    this.cdr.detectChanges();
  }
  previous() {
    if (this.activeIndex > 0) {
      this.activeIndex--;
    }
    this.component = this.slides.toArray()[this.activeIndex];
  }
  next() {
    if (this.activeIndex < this.slides.length - 1) {
      this.activeIndex++;
    }
    this.component = this.slides.toArray()[this.activeIndex];
  }
}
