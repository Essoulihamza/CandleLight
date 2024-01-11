import { gql } from "apollo-angular";

export const GET_POST = gql`
     query ($id: ID!) {
        postById(id : $id){
           id
           title
           content
           publishTime
           Tags
            publisher {
               id
               userName
               email
   }
  }
 }
`;

export const PAGINATE_POSTS = gql`
       query ($page : Int!, $pageSize : Int!) {
       PaginatePost(page : $page , pageSize : $pageSize) {
         id
         title
         content
         publishTime
         Tags
         publisher{
           userName
           email
    }
  }
}
   `;


export const DELETE_POST = gql`
    mutation ($id: ID!) {
      deletePost(aLong : $id)
    }
  `;


export const UPDATE_POST = gql`
  mutation ($id: ID!, $post: PostInput!) {
    updatePost(Post : $post ,id : $id){
      id
      title
      content
      publishTime
      Tags
      publisher{
        userName
        email
      }
    }
  }
  `;


export const SEARCH_USERS_BY_USER_NAME_LIKE = gql`
     query ($userName: String!) {
        searchUsersByUserNameLike(userName : $userName){
          id
          userName
          email
          phoneNumber    
        }
   }
`;