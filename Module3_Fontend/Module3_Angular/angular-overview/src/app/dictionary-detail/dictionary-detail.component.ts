import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { DictionaryService, IWord } from './../dictionary.service';
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css'],
})
export class DictionaryDetailComponent implements OnInit, OnDestroy {
  word: IWord;
  sub: Subscription;

  constructor(
    private dictionaryService: DictionaryService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.sub = this.activatedRoute.paramMap.subscribe((paramMap) => {
      const key = paramMap.get('key');
      this.word = this.dictionaryService.search(key);
    });
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
