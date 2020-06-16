import { LocalStorageService } from './local-storage.service';
import { Injectable } from '@angular/core';
import { Todo } from '../models/todo.model';
import { BehaviorSubject, Observable } from 'rxjs';
import { Filter } from '../models/filtering.model';

@Injectable({
  providedIn: 'root',
})
export class TodoService {
  private static readonly todoStorageKey = 'todos';
  private todos: Todo[];
  private filteredTodos: Todo[];
  private lengthSubject: BehaviorSubject<number> = new BehaviorSubject(0);
  private displayTodosSubject: BehaviorSubject<Todo[]> = new BehaviorSubject(
    []
  );
  private currentFilter: Filter = Filter.All;
  todos$: Observable<Todo[]> = this.displayTodosSubject.asObservable();
  length$: Observable<number> = this.lengthSubject.asObservable();
  constructor(private localStorageService: LocalStorageService) {}

  fetchFromLocalStorage() {
    this.todos =
      this.localStorageService.getValue<Todo[]>(TodoService.todoStorageKey) ||
      [];
    this.filteredTodos = [...this.todos];
    this.updateTodoData();
  }

  private updateTodoData() {
    this.displayTodosSubject.next(this.filteredTodos);
    this.lengthSubject.next(this.todos.length);
  }

  updateToLocalStorage() {
    this.localStorageService.setObject(TodoService.todoStorageKey, this.todos);
    this.filterTodos(this.currentFilter, false);
    this.updateTodoData();
  }

  filterTodos(filter: Filter, isFiltering: boolean = true) {
    this.currentFilter = filter;
    switch (filter) {
      case Filter.Active:
        this.filteredTodos = this.todos.filter(
          (todo) => !(todo as any).isCompleted
        );
        break;
      case Filter.Completed:
        this.filteredTodos = this.todos.filter(
          (todo) => (todo as any).isCompleted
        );
        break;
      case Filter.All:
        this.filteredTodos = [...this.todos];
        break;
    }
    if (isFiltering) {
      this.updateToLocalStorage();
    }
  }

  addTodo(content: string) {
    const date = new Date(Date.now()).getTime();
    const newTodo: Todo = new Todo(date, content);
    this.todos.unshift(newTodo);
    this.updateToLocalStorage();
  }

  changeTodoStatus(id: number, status: boolean) {
    const index = this.todos.findIndex((item) => item.id === id);
    const todo = this.todos[index];
    todo.isCompleted = status;
    this.todos.splice(index, 1, todo);
    this.updateToLocalStorage();
  }

  editTodo(id: number, content: string) {
    const index = this.todos.findIndex((item) => item.id === id);
    const todo = this.todos[index];
    todo.content = content;
    this.todos.splice(index, 1, todo);
    this.updateToLocalStorage();
  }

  deleteTodo(id: number) {
    const index = this.todos.findIndex((item) => item.id === id);
    this.todos.splice(index, 1);
    this.updateToLocalStorage();
  }

  toggleAll() {
    this.todos = this.todos.map((todo) => {
      return {
        ...todo,
        isCompleted: this.todos.every((i) => !i.isCompleted),
      };
    });
    this.updateToLocalStorage();
  }

  clearCompleted() {
    this.todos = this.todos.filter((todo) => !todo.isCompleted);
    this.updateToLocalStorage();
  }
}
