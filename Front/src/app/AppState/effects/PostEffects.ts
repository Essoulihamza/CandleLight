import { Injectable } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { catchError, exhaustMap, map, of } from "rxjs";
import { PostService } from "src/app/Services/Service/PostService/post.service";
import { Post } from "src/app/Types/PostTypes";


@Injectable()
export class PostEffects {

    constructor(
        private actions$: Actions,
        private postService: PostService,
    ) { }

    cretaePost$ = createEffect(() => this.actions$.pipe(
        ofType('[Post] createPost'),
        exhaustMap((action) => this.postService.createPost(action).pipe(
            map((response): Post => this.actions$.post(response)),
            catchError((error: any) => of(error))))
    ))
}