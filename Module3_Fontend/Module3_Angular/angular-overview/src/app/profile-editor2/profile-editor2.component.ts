import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormArray } from '@angular/forms';

@Component({
  selector: 'app-profile-editor2',
  templateUrl: './profile-editor2.component.html',
  styleUrls: ['./profile-editor2.component.css']
})
export class ProfileEditor2Component implements OnInit {
  profile = this.fb.group({
    firstName: ['', Validators.required],
    lastName: [''],
    address: this.fb.group({
      street: [''],
      city: [''],
      state: [''],
      zip: ['']
    }),
    aliases: this.fb.array([this.fb.control('')])
  });

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {}

  get info() {
    return JSON.stringify(this.profile.value);
  }

  get aliases() {
    return this.profile.get('aliases') as FormArray;
  }

  addAlias() {
    this.aliases.push(this.fb.control(''));
  }

  onSubmit() {}
}
