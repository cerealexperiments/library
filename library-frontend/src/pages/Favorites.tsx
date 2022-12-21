import React, {useContext} from 'react';
import axios from "axios";
import AuthContext from "../context/AuthContext";
import {useQuery} from "react-query";
import Book from "../components/Book";

type ResponseItemType = {
  id: number;
  name: string;
  authorDto: {
    id: number;
    name: string,
  },
  genre: string,
  price: number
}

const Favorites = () => {
  const authContext = useContext(AuthContext);

  const getFavoriteBooks = async(): Promise<ResponseItemType[]> => {
    const response = await axios.get(`http://localhost:8080/api/v1/books/find-favourite-books/${authContext.userInfo?.id}`)
    return response.data;
  }

  // const query = useQuery("favoriteBooks", getFavoriteBooks);

  return (

    <div className="max-w-screen-xl mx-auto w-full py-4">
      <h2 className="text-2xl font-medium pb-8">Favorite Books</h2>
      {/*{query.isLoading && <p>Loading...</p>}*/}
      {/*{query.isSuccess && query.data.map(item => <Book key={item.id} id={item.id} name={item.name} author={item.authorDto.name} price={item.price} genre={item.genre}/>)}*/}
      {/*{query.isError && <p>some error was thrown</p>}*/}
    </div>
  );
};

export default Favorites;
