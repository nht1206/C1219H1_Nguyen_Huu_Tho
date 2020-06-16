import { PostService } from './../../service/post.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Post } from './../../model/post';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css'],
})
export class BlogComponent implements OnInit {
  postList: Post[] = [];
  postForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private postService: PostService
  ) {}

  ngOnInit(): void {
    this.postForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.minLength(10)]],
      body: ['', [Validators.required, Validators.minLength(10)]],
    });
    this.postService.getPosts().subscribe(
      (next) => (this.postList = next),
      (error) => (this.postList = [])
    );
  }

  onSubmit(): void {
    if (this.postForm.valid) {
      const { value } = this.postForm;
      this.postService.createPost(value).subscribe(
        (next) => {
          this.postList.unshift(next);
          this.postForm.reset({
            title: '',
            body: '',
          });
        },
        (error) => console.log(error)
      );
    }
  }

  deletePost(id): void {
    const post = this.postList[id];
    this.postService.deletePost(post.id).subscribe(() => {
      this.postList = this.postList.filter((p) => p.id !== post.id);
    });
  }
}
