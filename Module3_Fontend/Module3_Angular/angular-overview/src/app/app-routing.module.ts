import { ImageSlidePageComponent } from './image-slide/components/image-slide-page/image-slide-page.component';
import { ImageGalleryComponent } from './image-gallery/components/image-gallery/image-gallery.component';
import { DictionaryDetailComponent } from './dictionary-detail/dictionary-detail.component';
import { DictionaryPageComponent } from './dictionary-page/dictionary-page.component';
import { YoutubePlayerComponent } from './youtube-player/youtube-player.component';
import { YoutubePlaylistComponent } from './youtube-playlist/youtube-playlist.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import { FontSizeEditorComponent } from './font-size-editor/font-size-editor.component';
import { PetComponent } from './pet/pet.component';
import { CalculateComponent } from './calculate/calculate.component';
import { AngularColorPickerComponent } from './angular-color-picker/angular-color-picker.component';
import { ToDoComponent } from './to-do/to-do.component';
import { ComponentPracticeComponent } from './component-practice/component-practice.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MyHeroComponent } from './my-hero/my-hero.component';
import { NameEditorComponent } from './name-editor/name-editor.component';
import { ProfileEditorComponent } from './profile-editor/profile-editor.component';
import { ProfileEditor2Component } from './profile-editor2/profile-editor2.component';
import { LifeTimeComponent } from './life-time/life-time.component';

const routes: Routes = [
  { path: 'font-size-editor', component: FontSizeEditorComponent },
  { path: 'pet', component: PetComponent },
  { path: 'calculate', component: CalculateComponent },
  { path: 'color-picker', component: AngularColorPickerComponent },
  { path: 'todo-list', component: ToDoComponent },
  { path: 'component', component: ComponentPracticeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'hero', component: MyHeroComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'name-editor', component: NameEditorComponent },
  { path: 'profile-editor', component: ProfileEditorComponent },
  { path: 'profile-editor-2', component: ProfileEditor2Component },
  { path: 'life-time', component: LifeTimeComponent },
  {
    path: 'youtube-playlist',
    component: YoutubePlaylistComponent,
    children: [{ path: ':id', component: YoutubePlayerComponent }],
  },
  {
    path: 'dictionary',
    component: DictionaryPageComponent,
    children: [{ path: ':key', component: DictionaryDetailComponent }],
  },
  { path: 'image-gallery', component: ImageGalleryComponent },
  { path: 'image-slide', component: ImageSlidePageComponent },
  { path: 'blog', loadChildren: './blog/blog.module#BlogModule' },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {
      preloadingStrategy: PreloadAllModules,
    }),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
