import React, { useContext } from 'react';
import BooksList from "../components/BooksList.jsx";
import BooksContext from "../context/BooksContext.jsx";
import {motion} from "framer-motion";

function Books() {

  const { data, isLoading } = useContext(BooksContext);

  return (
    <motion.div
      initial={{opacity: 0}}
      animate={{opacity: 1}}
      exit={{opacity: 0}}
      >
      <h2 className="font-semibold text-lg pb-6">Books</h2>
      {isLoading && <p>Loading...</p>}
      {data && <BooksList books={data} />}
    </motion.div>
  );
}

export default Books;