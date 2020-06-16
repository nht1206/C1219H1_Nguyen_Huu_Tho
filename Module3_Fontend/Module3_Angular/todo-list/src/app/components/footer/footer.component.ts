import { TodoService } from './../../services/todo.service';
import { Observable, Subject } from 'rxjs';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { FilterButton, Filter } from 'src/app/models/filtering.model';
import { map, takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent implements OnInit, OnDestroy {
  filterButtons: FilterButton[] = [
    { type: Filter.All, label: 'All', isActive: true },
    { type: Filter.Completed, label: 'Completed', isActive: false },
    { type: Filter.Active, label: 'Active', isActive: false },
  ];
  length = 0;
  hasCompleted$: Observable<boolean>;
  destroy$: Subject<null> = new Subject();

  constructor(private todoService: TodoService) {}

  ngOnInit(): void {
    this.hasCompleted$ = this.todoService.todos$.pipe(
      map((todos) => todos.some((t) => t.isCompleted)),
      takeUntil(this.destroy$)
    );
    this.todoService.length$
      .pipe(takeUntil(this.destroy$))
      .subscribe((length) => {
        this.length = length;
      });
  }

  filter(filter: Filter) {
    this.filterButtons.forEach((btn) => {
      btn.isActive = btn.type === filter;
    });
    this.todoService.filterTodos(filter, true);
  }

  clearComplete() {
    this.todoService.clearCompleted();
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
