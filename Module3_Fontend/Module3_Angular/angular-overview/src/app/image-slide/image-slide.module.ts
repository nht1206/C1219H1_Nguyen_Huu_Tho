import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageSlideComponent } from './components/image-slide/image-slide.component';
import { ImageSliderComponent } from './components/image-slider/image-slider.component';
import { ImageSlidePageComponent } from './components/image-slide-page/image-slide-page.component';

@NgModule({
  declarations: [
    ImageSlideComponent,
    ImageSliderComponent,
    ImageSlidePageComponent,
  ],
  imports: [CommonModule],
  exports: [ImageSlidePageComponent],
})
export class ImageSlideModule {}
