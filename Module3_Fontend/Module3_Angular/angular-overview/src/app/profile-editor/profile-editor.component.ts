import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-profile-editor',
  templateUrl: './profile-editor.component.html',
  styleUrls: ['./profile-editor.component.css']
})
export class ProfileEditorComponent implements OnInit {
  profile = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    address: new FormGroup({
      street: new FormControl(''),
      city: new FormControl(''),
      state: new FormControl(''),
      zip: new FormControl('')
    })
  });

  constructor() {}

  ngOnInit(): void {}

  onSubmit() {
    console.warn(this.profile.value);
  }
  updateProfile() {
    this.profile.patchValue({
      firstName: 'Nancy',
      address: {
        street: '123 Ton Duc Thang'
      }
    });
  }
  get info() {
    return JSON.stringify(this.profile.value);
  }
}
