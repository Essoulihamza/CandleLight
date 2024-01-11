import { gql } from "apollo-angular";

export const CREATE_POST = gql`
mutation ($newPost : PostInput!){
  createPost(
    newPost: $newPost
  ) {
    id
    title
    content
    Tags
    publisher {
      userName
      email
      phoneNumber
    }
  }
}
`;


export const UPDATE_POST = gql`
mutation ($updatePost : PostInput! , $id : ID!){
  updatePost(
    updatePost: $updatePost
  ) {
    id
    title
    content
    Tags
    publisher {
      userName
      email
      phoneNumber
    }
  }
}
`;

export const USER_LOGIN = gql`
mutation ($user : UserLoginInput!){
  login(
    user: $user
  ) {
    id
    userName
    email
    phoneNumber
  }
}
`;

export const USER_SIGNUP = gql`
mutation ($user : UserSignUpInput!){
  signUp(
    user: $user
  ) {
    id
    userName
    email
    phoneNumber
  }
}
`;