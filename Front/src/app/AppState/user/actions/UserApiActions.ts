import { createAction, props } from "@ngrx/store";
import { User } from "src/app/Types/UserType";

export const userSignedUpSuccessfully = createAction(
    "[User API] User signed up successfully",
    props<{user : User}>()
);

export const userSignedUpFailure = createAction(
    "[User API] User signed up failure",
    props<{message: string}>()
);

export const userLoggedSuccessfully = createAction(
    "[User API] User logged successfully",
    props<{user: User}>()
);

export const userLoggedFailure = createAction(
    "[User API] User logged failure",
    props<{message: string}>()
);

export const usersFounded = createAction(
    "[User API] Users founded",
    props<{users: User[]}>()
);
