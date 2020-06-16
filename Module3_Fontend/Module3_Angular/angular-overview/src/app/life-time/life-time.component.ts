import { DateUtilService } from './../date-util.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-life-time',
  templateUrl: './life-time.component.html',
  styleUrls: ['./life-time.component.css'],
})
export class LifeTimeComponent implements OnInit {
  output = '';

  constructor(private dateUtilService: DateUtilService) {}

  ngOnInit(): void {}

  onChange(value) {
    this.output = this.dateUtilService.getDiffToNow(value);
  }
}
