import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-name-card',
  templateUrl: './name-card.component.html',
  styleUrls: ['./name-card.component.css']
})
export class NameCardComponent implements OnInit {

  @Input() cardName: String;
  @Input() email: String;
  @Input() phone: String;

  constructor() { }

  ngOnInit(): void {
  }

}
