import { Post } from './../model/post';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  private readonly API_URL = 'http://jsonplaceholder.typicode.com/posts';

  constructor(private httpClient: HttpClient) {}

  getPosts(count = 10): Observable<Post[]> {
    return this.httpClient
      .get<Post[]>(this.API_URL)
      .pipe(map((res) => res.filter((todo, i) => i < count)));
  }

  getPostById(id: number): Observable<Post> {
    return this.httpClient.get<Post>(`${this.API_URL}/${id}`);
  }

  createPost(post: Partial<Post>): Observable<Post> {
    return this.httpClient.post<Post>(this.API_URL, post);
  }

  deletePost(id: number): Observable<any> {
    return this.httpClient.delete(`${this.API_URL}/${id}`);
  }

  updatePost(post: Post): Observable<Post> {
    return this.httpClient.patch<Post>(`${this.API_URL}/${post.id}`, post);
  }
}
