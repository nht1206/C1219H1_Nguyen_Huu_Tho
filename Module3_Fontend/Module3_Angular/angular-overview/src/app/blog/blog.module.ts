import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BlogRoutingModule } from './blog-routing.module';
import { BlogComponent } from './component/blog/blog.component';
import { BlogEditComponent } from './component/blog-edit/blog-edit.component';
import { BlogDetailComponent } from './component/blog-detail/blog-detail.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [BlogComponent, BlogEditComponent, BlogDetailComponent],
  imports: [CommonModule, BlogRoutingModule, FormsModule, ReactiveFormsModule],
})
export class BlogModule {}
