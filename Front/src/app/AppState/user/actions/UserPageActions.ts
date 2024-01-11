import { createAction, props } from "@ngrx/store";
import { UserLoginInput, UserSignUpInput } from "src/app/Types/UserType";

export const signUp = createAction(
    "[User SignUp form] sign up",
    props<{newUser: UserSignUpInput}>()
);

export const login = createAction(
    "[User login form] login",
    props<{user: UserLoginInput}>()
);

export const searchUser = createAction(
    "[User search input] search User",
    props<{userName: string}>()
);