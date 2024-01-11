import { createAction, props } from "@ngrx/store";
import { Post, PostInput } from "src/app/Types/PostTypes";

export const createPost = createAction(
    '[Post] creatvPost',
    props<{ post: PostInput }>()
);

export const updatePost = createAction(
    '[Post] updatePost',
    props<{ post: PostInput, id: number }>()
);

export const post = createAction(
    '[Post] post',
    props<{ post: Post }>()
);

export const deletePost = createAction(
    '[Post] deletePost',
    props<{ id: number }>()
);

export const getPost = createAction(
    '[Post] getPost',
    props<{ id: number }>()
);

export const paginatePosts = createAction(
    '[Post] paginatePosts',
    props<{ page: number, pageSize: number }>()
);
