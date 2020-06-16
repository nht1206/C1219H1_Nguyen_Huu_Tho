import { TodoService } from './../../services/todo.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todo-input',
  templateUrl: './todo-input.component.html',
  styleUrls: ['./todo-input.component.scss'],
})
export class TodoInputComponent implements OnInit {
  todoContent = '';

  constructor(private todoService: TodoService) {}

  ngOnInit(): void {}
  onSubmit() {
    if (this.todoContent.trim() === '') {
      return false;
    }
    this.todoService.addTodo(this.todoContent);
    this.todoContent = '';
  }
}
