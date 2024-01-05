import { catchError } from 'rxjs';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Apollo } from 'apollo-angular';
import { Injectable } from '@angular/core';
import { DELETE_POST, GET_POST, PAGINATE_POSTS } from '../../Querys/QueryPost';
import { Post, PostInput } from 'src/app/Types/PostTypes';
import { CREATE_POST } from '../../Querys/MutationPost';


@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private apollo: Apollo) { }

  public getPostById(Id: number): Observable<Post> {
    return this.apollo
      .watchQuery({
        query: GET_POST,
        variables: {
          id: Id,
        },
      })
      .valueChanges
      .pipe(
        map((result: any) => {
          return result.data.postById;
        }),
        catchError((error) => {
          console.error(error);
          return of(error);
        })
      );
  }

  public getPosts(page: number, pageSize: number): Observable<Post[]> {
    return this.apollo
      .watchQuery({
        query: PAGINATE_POSTS,
        variables: {
          page: page,
          pageSize: pageSize
        },
      })
      .valueChanges
      .pipe(
        map((result: any) => {
          return result.data.PaginatePost;
        }),
        catchError((error) => {
          console.error(error);
          return of(error);
        })
      );
  }

  public createPost(post: PostInput): Observable<Post> {
    return this.apollo
      .mutate({
        mutation: CREATE_POST,
        variables: {
          newPost: post,
        },
      })
      .pipe(
        map((result: any) => {
          return result.data.createPost;
        }),
        catchError((error) => {
          console.error(error);
          return of(error);
        })
      );
  }

  public updatePost(post: PostInput, id: number): Observable<Post> {
    return this.apollo
      .mutate({
        mutation: CREATE_POST,
        variables: {
          updatePost: post,
          id: id
        },
      })
      .pipe(
        map((result: any) => {
          return result.data.updatePost;
        }),
        catchError((error) => {
          console.error(error);
          return of(error);
        })
      );
  }

  public deletePost(id: number): Observable<Post> {
    return this.apollo
      .mutate({
        mutation: DELETE_POST,
        variables: {
          id: id
        },
      })
      .pipe(
        map((result: any) => {
          return result.data.deletePost;
        }),
        catchError((error) => {
          console.error(error);
          return of(error);
        })
      );
  }


}
