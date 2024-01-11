import { Injectable } from '@angular/core';
import { Apollo } from 'apollo-angular';
import { Observable, catchError, map, of } from 'rxjs';
import { User, UserLoginInput, UserSignUpInput } from 'src/app/Types/UserType';
import { USER_LOGIN, USER_SIGNUP } from '../../Querys/MutationPost';
import { SEARCH_USERS_BY_USER_NAME_LIKE } from '../../Querys/QueryPost';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private apollo: Apollo ){}

  public signUp(user: UserSignUpInput): Observable<User> {
    return this.apollo
      .mutate({
        mutation: USER_SIGNUP,
        variables: {
          newUser: user,
        },
      })
      .pipe(
        map((result: any) => {
          return result.data.newUser;
        }),
        catchError((error) => {
          console.error(error);
          return of(error);
        })
      );
  }

  public login(user: UserLoginInput): Observable<User> {
    return this.apollo
      .mutate({
        mutation: USER_LOGIN,
        variables: {
          user
        },
      })
      .pipe(
        map((result: any) => {
          return result.data.user;
        }),
        catchError((error) => {
          console.error(error);
          return of(error);
        })
      );
  }

  public search(userName: string): Observable<User[]> {
    return this.apollo
      .query({
        query: SEARCH_USERS_BY_USER_NAME_LIKE,
        variables: {
          userName
        },
      })
      .pipe(
        map((result: any) => {
          return result.data.users;
        }),
        catchError((error) => {
          console.error(error);
          return of(error);
        })
      );
  }

}
