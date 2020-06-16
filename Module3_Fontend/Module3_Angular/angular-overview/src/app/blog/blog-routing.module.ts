import { BlogEditComponent } from './component/blog-edit/blog-edit.component';
import { BlogDetailComponent } from './component/blog-detail/blog-detail.component';
import { BlogComponent } from './component/blog/blog.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', component: BlogComponent },
  { path: ':id', component: BlogDetailComponent },
  { path: ':id/edit', component: BlogEditComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BlogRoutingModule {}
