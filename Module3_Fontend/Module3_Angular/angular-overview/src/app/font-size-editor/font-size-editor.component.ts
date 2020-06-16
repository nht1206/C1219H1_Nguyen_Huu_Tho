import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-font-size-editor',
  templateUrl: './font-size-editor.component.html',
  styleUrls: ['./font-size-editor.component.css']
})
export class FontSizeEditorComponent implements OnInit {

  test = 8;
  fontSize = 14;
  test2 = 'Nguyen Huu Tho';

  constructor() { }

  onChange(value) {
    this.fontSize = value;
  }


  ngOnInit(): void {
  }

}
