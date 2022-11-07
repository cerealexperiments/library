import React, {useState} from 'react';
import axios from "axios";
import { useQuery, useMutation } from "@tanstack/react-query";

function AddBook() {

  const postBook =  () => {
     axios.post("http://127.0.0.1:8090/api/collections/books/records", {
      name: name,
      author_name: author,
      price: price,
      image_url: imageUrl,
      genre: genre
    }).then(res => console.log(res));
  }

  const {mutate, isLoading, isSuccess} = useMutation(postBook);

  const [name, setName] = useState("");
  const [author, setAuthor] = useState("");
  const [price, setPrice] = useState(0);
  const [imageUrl, setImageUrl] = useState("");
  const [genre, setGenre] = useState("");

  return (
    <div>
      <h1 className={"text-xl font-semibold"}>Add Book</h1>
      <div className="flex flex-col pt-6 gap-2 mb-6">
        <div>
          <label className="label">
            <span className="label-text">Title</span>
          </label>
          <input onChange={(e) => setName(e.target.value)} value={name} type="text" placeholder="Enter title" className="input input-bordered w-full max-w-xs" />
        </div>
        <div>
          <label className="label">
            <span className="label-text">Author</span>
          </label>
          <input onChange={(e) => setAuthor(e.target.value)} value={author} type="text" placeholder="Enter author's name" className="input input-bordered w-full max-w-xs" />
        </div>
        <div>
          <label className="label">
            <span className="label-text">Price</span>
          </label>
          <input onChange={(e) => setPrice(Number(e.target.value))} value={price} type="number" placeholder={`Enter price`} className="input input-bordered w-full max-w-xs" />
        </div>
        <div>
          <label className="label">
            <span className="label-text">Image (url)</span>
          </label>
          <input onChange={(e) => setImageUrl(e.target.value)} value={imageUrl} type="url" placeholder="Enter image URL" className="input input-bordered w-full max-w-xs" />
        </div>
        <div>
          <label className="label">
            <span className="label-text">Genre</span>
          </label>
          <select onChange={(e) => setGenre(e.target.value)} value={genre} className="select select-bordered w-full max-w-xs">
            <option value={""} defaultValue={""}>Select genre</option>
            <option value={"action"}>Action</option>
            <option value={"adventure"}>Adventure</option>
            <option value={"detective"}>Detective</option>
            <option value={"love"}>Love</option>
            <option value={"horror"}>Horror</option>
          </select>
        </div>
      </div>
      <button onClick={mutate} className="btn">Submit</button>
      {isLoading && <p>Performing Mutation...</p>}
      {isSuccess && <p>Mutation successful!</p>}
    </div>
  );
}

export default AddBook;