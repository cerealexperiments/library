import React, { useState } from 'react';
import axios from "axios";
import {useMutation} from "react-query";

const AddBook = () => {
  const [name, setName] = useState("");
  const [author, setAuthor] = useState("");
  const [price, setPrice] = useState<number>();
  const [imageUrl, setImageUrl] = useState("");
  const [genre, setGenre] = useState("ACTION");

  const addBook = async () => {
    await axios.post("http://localhost:8080/api/v1/books/save-book", {
      name: name,
      authorName: author,
      price: price,
      genre: genre
    })
  }

  const mutation = useMutation(addBook);

  const handleSubmit = () => {
    console.log(`${name}, ${author}, ${price}, ${imageUrl}, ${genre}`);
  }

  return (
    <div className='max-w-screen-xl mx-auto w-full py-4'>
      <h2 className="text-2xl font-medium pb-8">Add Book</h2>
      <div className="form-control w-full max-w-xs space-y-4">
        <div>
          <label className="label">
            <span className="label-text">Name</span>
          </label>
          <input onChange={(event) => setName(event.target.value)} type="text" placeholder="Type here" className="input input-bordered w-full max-w-xs"/>
        </div>

        <div>
          <label className="label">
            <span className="label-text">Author</span>
          </label>
          <input onChange={(event) => setAuthor(event.target.value)} type="text" placeholder="Type here" className="input input-bordered w-full max-w-xs"/>
        </div>

        <div>
          <label className="label">
            <span className="label-text">Price</span>
          </label>
          <input onChange={(event) => setPrice(Number(event.target.value))} type="number" placeholder="Type here" className="input input-bordered w-full max-w-xs"/>
        </div>

        <div>
          <label className="label">
            <span className="label-text">Image (URL)</span>
          </label>
          <input onChange={(event) => setImageUrl(event.target.value)} type="text" placeholder="Type here" className="input input-bordered w-full max-w-xs"/>
        </div>

        <div>
          <label className="label">
            <span className="label-text">Genre</span>
          </label>
          <select defaultValue="action" onChange={event => setGenre(event.target.value)} className="select select-bordered w-full max-w-xs">
            <option disabled >Select genre</option>
            <option value="ACTION">ACTION</option>
            <option value="DRAMA">DRAMA</option>
          </select>
        </div>
        {mutation.isLoading && <p>adding book...</p>}
        {mutation.isSuccess && <p>Book added!</p>}
        {mutation.isError && <p>could not add book</p>}
        <button onClick={() => mutation.mutate()} className="btn self-start">Submit</button>
      </div>
    </div>
  );
};

export default AddBook;
