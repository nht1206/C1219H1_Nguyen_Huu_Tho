import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculate',
  templateUrl: './calculate.component.html',
  styleUrls: ['./calculate.component.css']
})
export class CalculateComponent implements OnInit {

  first = '0';
  second = '0';
  operate = '';
  result = '';

  constructor() { }

  ngOnInit(): void {
  }

  onOperationChange(value) {
    this.operate = value;
  }

  onFirstChange(value) {
    this.first = value;
  }

  onSecondChange(value) {
    this.second = value;
  }

  onSubmit() {
    switch(this.operate) {
      case "+":
        this.result = (parseInt(this.first) + parseInt(this.second)) + "";
        break;
      case "-":
        this.result = (parseInt(this.first) - parseInt(this.second)) + "";
        break;
      case "*":
        this.result = (parseInt(this.first) * parseInt(this.second)) + "";
        break;
      case "/":
        if (this.second === "0")
          this.result = "Can not divide a number by zero.";
        else
          this.result = (parseInt(this.first) / parseInt(this.second)) + "";
          break;

    }
  }

}
