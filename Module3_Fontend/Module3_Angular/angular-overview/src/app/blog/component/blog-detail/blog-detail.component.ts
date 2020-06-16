import { PostService } from './../../service/post.service';
import { ActivatedRoute } from '@angular/router';
import { Post } from './../../model/post';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.css'],
})
export class BlogDetailComponent implements OnInit {
  post: Post;

  constructor(
    private activatedRoute: ActivatedRoute,
    private postService: PostService
  ) {}

  ngOnInit(): void {
    const id = +this.activatedRoute.snapshot.paramMap.get('id');
    this.postService.getPostById(id).subscribe((next) => {
      this.post = next;
    });
  }
}
