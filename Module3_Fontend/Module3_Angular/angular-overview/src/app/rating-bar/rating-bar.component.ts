import {
  Component,
  OnInit,
  Input,
  Output,
  EventEmitter,
  SimpleChanges,
  OnChanges,
} from '@angular/core';

interface IRatingUnit {
  value: number;
  active: boolean;
}

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css'],
})
export class RatingBarComponent implements OnInit, OnChanges {
  @Input()
  showRatingValue = true;
  @Input()
  ratingValue = 5;
  @Input()
  max = 5;

  ratingUnits: Array<IRatingUnit> = [];

  @Output()
  rateChange = new EventEmitter<number>();

  constructor() {}

  ngOnInit(): void {
    this.calculate(this.max, this.ratingValue);
  }

  ngOnChanges(changes: SimpleChanges): void {
    if ('max' in changes) {
      let max = changes.max.currentValue;
      max = typeof max === 'undefined' ? 5 : max;
      this.max = max;
      this.calculate(max, this.ratingValue);
    }
  }

  calculate(max, ratingValue) {
    this.ratingUnits = Array.from({ length: max }, (_, index) => ({
      value: index + 1,
      active: index < ratingValue,
    }));
  }

  select(index) {
    this.ratingValue = index + 1;
    this.reset();
    this.rateChange.emit();
  }

  enter(index) {
    this.ratingUnits.forEach((item, idx) => {
      return (item.active = idx <= index);
    });
  }

  reset() {
    this.ratingUnits.forEach((item, idx) => {
      return (item.active = idx < this.ratingValue);
    });
  }
}
