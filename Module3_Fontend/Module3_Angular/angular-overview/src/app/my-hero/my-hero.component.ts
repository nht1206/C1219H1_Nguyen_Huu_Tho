import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';

@Component({
  selector: 'app-my-hero',
  templateUrl: './my-hero.component.html',
  styleUrls: ['./my-hero.component.css']
})
export class MyHeroComponent implements OnInit {
  powers = ['Really smart', 'Super flexible', 'Super hot', 'Weather change'];
  model = new Hero(18, 'Dr IQ', this.powers[0], 'Chuck overstreet');
  submitted = false;

  constructor() {}

  ngOnInit(): void {}

  onSubmit() {
    this.submitted = true;
  }
  get diagnostic() {
    return JSON.stringify(this.model);
  }
  newHero() {
    this.model = new Hero(42, '', '');
  }
}
