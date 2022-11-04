import { useEffect, useState } from "react";
import styles from "./App.module.css";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Header from "./components/Header";
import About from "./pages/About";
import Books from "./pages/Books";
import AddBook from "./pages/AddBook";

function App() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    fetch("http://localhost:9090/api/v1/books/find-all")
      .then((res) => res.json())
      .then((data) => setBooks(data));
  }, []);

  return (
    <>
      <div className={styles.container}>
        <Header />
        <Routes>
          <Route path="/" element={<Home books={books} />} />
          <Route path="/about" element={<About />} />
          <Route path="/books" element={<Books books={books} />} />
          <Route path="/add" element={<AddBook />} />
        </Routes>
      </div>
    </>
  );
}

export default App;
