import { Post } from './../../model/post';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PostService } from './../../service/post.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { da } from 'date-fns/locale';

@Component({
  selector: 'app-blog-edit',
  templateUrl: './blog-edit.component.html',
  styleUrls: ['./blog-edit.component.css'],
})
export class BlogEditComponent implements OnInit {
  post: Post;
  postForm: FormGroup;

  constructor(
    private activatedRoute: ActivatedRoute,
    private postService: PostService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.postForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.minLength(10)]],
      body: ['', [Validators.required, Validators.minLength(10)]],
    });
    const id = +this.activatedRoute.snapshot.paramMap.get('id');
    this.postService.getPostById(id).subscribe(
      (next) => {
        this.post = next;
        this.postForm.patchValue(this.post);
      },
      (error) => {
        console.log(error);
        this.post = null;
      }
    );
  }

  onSubmit(): void {
    if (this.postForm.valid) {
      const { value } = this.postForm;
      const data = {
        ...this.post,
        ...value,
      };
      this.postService.updatePost(data).subscribe(
        (next) => {
          this.router.navigate(['/blog']);
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
}
