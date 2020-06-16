import { TodoService } from './../../services/todo.service';
import { Todo } from './../../models/todo.model';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.scss'],
})
export class TodoListComponent implements OnInit {
  todos$: Observable<Todo[]>;
  constructor(private todoService: TodoService) {}

  ngOnInit(): void {
    this.todos$ = this.todoService.todos$;
  }
  onChangeTodoStatus(todo: Todo) {
    this.todoService.changeTodoStatus(todo.id, todo.isCompleted);
  }
  onEditTodo(todo: Todo) {
    this.todoService.editTodo(todo.id, todo.content);
  }
  onDeleteTodo(todo: Todo) {
    this.todoService.deleteTodo(todo.id);
  }
}
