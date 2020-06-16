import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

interface ITodo {
  id: number;
  content: string;
  complete: boolean;
}

let defaultId = 0;

@Component({
  selector: 'app-to-do',
  templateUrl: './to-do.component.html',
  styleUrls: ['./to-do.component.css']
})
export class ToDoComponent implements OnInit {
  userInput = new FormControl();
  todoList: Array<ITodo> = [];

  constructor() {}

  ngOnInit(): void {}

  onChange() {
    const { value } = this.userInput;
    if (value) {
      console.log(value);
      const todo: ITodo = {
        id: defaultId++,
        content: value,
        complete: false
      };
      this.todoList.push(todo);
      this.userInput.setValue('');
    }
  }

  toggleTodo(i) {
    this.todoList[i].complete = !this.todoList[i].complete;
  }
}
