import { createReducer, on } from "@ngrx/store";
import { User } from "src/app/Types/UserType";
import * as pageActions from "./actions/UserPageActions";
import * as apiActions from "./actions/UserApiActions";


export interface UserState {
    loggedUser: User | null
    error: string | null
}

const initialState: UserState = {
    loggedUser: null,
    error: null
}

export const userReducer = createReducer(
    initialState,
    on(apiActions.userSignedUpSuccessfully,
       apiActions.userLoggedSuccessfully,
       (state, action) => ({
        ...state,
        loggedUser: action.user
       })
    ),
    on(apiActions.userLoggedFailure,
       apiActions.userSignedUpFailure,
       (state, action) => ({
        ...state,
        error: action.message
       })
    )
);