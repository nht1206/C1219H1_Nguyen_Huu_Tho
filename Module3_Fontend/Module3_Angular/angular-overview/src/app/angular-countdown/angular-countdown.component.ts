import { Component, OnInit, Input, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-angular-countdown',
  templateUrl: './angular-countdown.component.html',
  styleUrls: ['./angular-countdown.component.css']
})
export class AngularCountdownComponent implements OnInit, OnDestroy {

  private intervalId = 0;
  message = '';
  remainingTime: number;

  @Input()
  second = 11;
  
  constructor() { }
  ngOnDestroy(): void {
    this.clearTimer();
  }

  ngOnInit(): void {
    this.reset();
    this.start();
  }

  private countDown(): void {
    this.clearTimer();
    this.intervalId = window.setInterval(() => {
      this.remainingTime -=1;
      if (this.remainingTime === 0) {
        this.message = 'blast off';
        this.clearTimer();
      } else {
        this.message = `T-${this.remainingTime} seconds and counting`;
      }
    }, 1000);
  }

  clearTimer() {
    clearInterval(this.intervalId);
  }

  reset(): void {
    this.clearTimer();
    this.remainingTime = this.second;
    this.message = "Click start to start the countdown.";
  }

  start(): void {
    this.countDown();
    if (this.remainingTime <= 0) {
      this.remainingTime = this.second;
    }
  }

  stop(): void {
    this.clearTimer();
    this.message = `Holding at T-${this.remainingTime} seconds`;
  }



}
