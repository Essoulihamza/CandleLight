import { Injectable } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { UserService } from "src/app/Services/Service/UserService/user.service";
import * as pageActions from "./actions/UserPageActions";
import * as apiActions from "./actions/UserApiActions";
import { catchError, exhaustMap, map } from "rxjs";

@Injectable()
export class UserEffect {

    constructor(private actions$: Actions,private service: UserService){}

    signUp = createEffect(() => this.actions$.pipe(
        ofType(pageActions.signUp),
        exhaustMap(
            (action) => this.service.signUp(action.newUser)
            .pipe(
                map(user => apiActions.userSignedUpSuccessfully({user}))
            )
        )
    )
    );

    login = createEffect(() => this.actions$.pipe(
        ofType(pageActions.login),
        exhaustMap(
            (action) => this.service.login(action.user)
            .pipe(
                map(user => apiActions.userLoggedSuccessfully({user}))
            )
        )
    )
    );

    search = createEffect(() => this.actions$.pipe(
        ofType(pageActions.searchUser),
        exhaustMap(
            (action) => this.service.search(action.userName)
            .pipe(
                map(users => apiActions.usersFounded({users}))
            )
        )
    )
    );
}