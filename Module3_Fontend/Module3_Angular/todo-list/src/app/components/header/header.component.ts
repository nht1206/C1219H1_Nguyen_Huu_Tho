import { Observable } from 'rxjs';
import { TodoService } from './../../services/todo.service';
import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/models/todo.model';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  constructor(private todoService: TodoService) {}

  ngOnInit(): void {}

  toggleAll() {
    this.todoService.toggleAll();
  }
}
