import { DictionaryService, IWord } from './../dictionary.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css'],
})
export class DictionaryPageComponent implements OnInit {
  wordList: IWord[];

  constructor(private dictionaryService: DictionaryService) {}

  ngOnInit(): void {
    this.wordList = this.dictionaryService.getAll();
  }
}
