export interface User {
    id?: number
    userName: string
    email: string
    phoneNumber: string
    joinedAt: Date
}

export interface UserLoginInput {
    userName: string
    password: string
}

export interface UserSignUpInput {
    userName: string
    email: string
    phoneNumber: string
    password: string
}