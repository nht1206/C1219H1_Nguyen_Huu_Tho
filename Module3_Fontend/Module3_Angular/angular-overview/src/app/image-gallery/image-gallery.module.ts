import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageGalleryComponent } from './components/image-gallery/image-gallery.component';
import { ImageCardComponent } from './components/image-card/image-card.component';

@NgModule({
  declarations: [ImageGalleryComponent, ImageCardComponent],
  imports: [CommonModule],
  exports: [ImageGalleryComponent],
})
export class ImageGalleryModule {}
