import React, {useContext} from 'react';
import { BookType } from "../types";
import {IoBookmarkOutline} from "react-icons/io5";
import {useMutation} from "react-query";
import axios from "axios";
import AuthContext from "../context/AuthContext";

const Book: React.FC<BookType> = ({id, name, author, price, genre, imageUrl = "https://dynamicmediainstitute.org/wp-content/themes/dynamic-media-institute/imagery/default-book.png"}) => {

  const authContext = useContext(AuthContext);

  const favoriteBook = async(): Promise<any> => {
    const response = await axios.post(`http://localhost:8080/api/v1/books/mark-as-favourite/${authContext.userInfo?.id}/${id}`);
    return response.data;
  }

  const mutation = useMutation(favoriteBook);

  return (
    <div className="card w-72 bg-base-100 shadow-xl border-neutral border-2 rounded-xl">
      <figure>
        <img className="w-full h-56  object-cover object-top" src={imageUrl} alt="book cover"/>
      </figure>
      <div className="card-body">
        <div className="flex items-center justify-between">
          <h2 className="card-title flex justify-between text-base">{name}</h2>
          <button onClick={() => mutation.mutate()}><IoBookmarkOutline className="cursor-pointer" size="25px"/></button>
        </div>
        <p>{author}</p>
        <div className="card-actions justify-end pt-4">
          <button className="btn btn-sm">borrow</button>
          <button className="btn btn-sm">buy</button>
        </div>
        {mutation.isSuccess && <p>book favorited!</p>}
        {mutation.isError && <p>book already favorited</p>}
      </div>
    </div>
  );
};

export default Book;
