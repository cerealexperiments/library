import React, {useEffect} from 'react';
import {useQuery} from "@tanstack/react-query";
import {useParams} from "react-router-dom";
import axios from "axios";
import {motion} from "framer-motion";

function BookPage() {
  const { id } = useParams();

  const fetchBookById = async() => {
    console.log(`Book ID: ${id}`);
    const response = await axios.get(`http://127.0.0.1:8090/api/collections/books/records/${id}`);
    console.log(response.data);
    return response.data;
  }

  const {data, isLoading} = useQuery(["book"], fetchBookById)

  return (
    isLoading  ? <p>Loading...</p> :
      <motion.div
        initial={{opacity: 0}}
        animate={{opacity: 1}}
        exit={{opacity: 0}}
        className="hero max-h-full bg-base-200">
          <div className="hero-content flex-col lg:flex-row">
            <img src={data.image_url} className="min-w-[320px] h-[400px] rounded-lg object-cover object-center shadow-2xl" alt={"book cover"}/>
            <div>
              <h1 className="text-5xl font-bold">{data.name}</h1>
              <p className={"pt-4"}>By {data.author_name}</p>
              <p className="py-6">Provident cupiditate voluptatem et in. Quaerat fugiat ut assumenda excepturi exercitationem quasi. In deleniti eaque aut repudiandae et a id nisi.</p>
              <button className="btn btn-primary">Purchase</button>
            </div>
          </div>
      </motion.div>
  );
}

export default BookPage;