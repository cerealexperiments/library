export type UserType = {
  id?: number;
  username: string,
  email: string,
  password?: string,
  role: string;
  account?: number;
}

export type BookType = {
  id: number,
  name: string,
  author: string;
  imageUrl?: string,
  price: number;
  genre: string;
}

export type AuthorType = {
  id: number,
  name: string;
}

export type RoleType = "none" | "user" | "admin" | "moderator";

