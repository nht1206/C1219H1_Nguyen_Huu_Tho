import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';

@Component({
  selector: 'app-image-slide',
  templateUrl: './image-slide.component.html',
  styleUrls: ['./image-slide.component.css'],
})
export class ImageSlideComponent implements OnInit {
  @ViewChild('tmpl') template: TemplateRef<any>;

  constructor() {}

  ngOnInit(): void {}
}
