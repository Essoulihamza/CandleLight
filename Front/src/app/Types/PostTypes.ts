import { User } from "./UserType"

export interface Post {
    id : number
    title : string
    content : string
    publishTime :Date
    Tags : [string]
    publisher : User
}

export interface PostInput {
    title : string
    content : string
    Tags : string[] | null
    publisher : number
}