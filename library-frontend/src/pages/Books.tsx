import React from 'react';
import Book from "../components/Book";
import axios from "axios";
import {useQuery} from "react-query";

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

const getAllBooks = async (): Promise<ResponseItemType[]> => {
  const data = await axios.get("http://localhost:8080/api/v1/books/find-all");
  console.log(data.data)
  return data.data;
}


const Books: React.FC = () => {
  const query = useQuery("books", getAllBooks);

  return (
    <div className="max-w-screen-xl mx-auto w-full py-4">
      <h2 className="text-2xl font-medium pb-8">Books</h2>

      <div className="flex flex-wrap gap-8 justify-center">
        {query.isLoading ? <p>Loading...</p> : query.data?.map(item => <Book key={item.id} id={item.id} name={item.name} author={item.authorDto.name} price={item.price} genre={item.genre}/>)}
      </div>
    </div>
  );
};

export default Books;
