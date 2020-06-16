import { BlogModule } from './blog/blog.module';
import { ImageSlideModule } from './image-slide/image-slide.module';
import { GalleryConfig } from './image-gallery/models/token';
import { ImageGalleryModule } from './image-gallery/image-gallery.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontSizeEditorComponent } from './font-size-editor/font-size-editor.component';
import { PetComponent } from './pet/pet.component';
import { CalculateComponent } from './calculate/calculate.component';
import { AngularColorPickerComponent } from './angular-color-picker/angular-color-picker.component';
import { NameCardComponent } from './name-card/name-card.component';
import { ProgressBarComponent } from './progress-bar/progress-bar.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { AngularCountdownComponent } from './angular-countdown/angular-countdown.component';
import { ToDoComponent } from './to-do/to-do.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ComponentPracticeComponent } from './component-practice/component-practice.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { MyHeroComponent } from './my-hero/my-hero.component';
import { NameEditorComponent } from './name-editor/name-editor.component';
import { ProfileEditorComponent } from './profile-editor/profile-editor.component';
import { ProfileEditor2Component } from './profile-editor2/profile-editor2.component';
import { LifeTimeComponent } from './life-time/life-time.component';
import { YoutubePlaylistComponent } from './youtube-playlist/youtube-playlist.component';
import { YoutubePlayerComponent } from './youtube-player/youtube-player.component';
import { DictionaryPageComponent } from './dictionary-page/dictionary-page.component';
import { DictionaryDetailComponent } from './dictionary-detail/dictionary-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    PetComponent,
    CalculateComponent,
    AngularColorPickerComponent,
    NameCardComponent,
    ProgressBarComponent,
    RatingBarComponent,
    AngularCountdownComponent,
    ToDoComponent,
    ComponentPracticeComponent,
    RegisterComponent,
    LoginComponent,
    MyHeroComponent,
    NameEditorComponent,
    ProfileEditorComponent,
    ProfileEditor2Component,
    LifeTimeComponent,
    YoutubePlaylistComponent,
    YoutubePlayerComponent,
    DictionaryPageComponent,
    DictionaryDetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    ImageGalleryModule,
    ImageSlideModule,
    HttpClientModule,
  ],
  providers: [{ provide: GalleryConfig, useValue: 4 }],
  bootstrap: [AppComponent],
})
export class AppModule {}
