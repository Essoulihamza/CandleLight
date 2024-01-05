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