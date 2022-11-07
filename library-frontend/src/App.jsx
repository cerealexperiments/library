import Header from "./components/Header.jsx";
import {Routes, Route} from "react-router-dom";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import Home from "./pages/Home.jsx";
import AddBook from "./pages/AddBook.jsx";
import About from "./pages/About.jsx";
import Books from "./pages/Books.jsx";

function App() {
  const client = new QueryClient({});
  return (
    <div className={"max-w-screen-lg mx-auto pt-4 px-4 lg:px-0"}>
      <QueryClientProvider client={client}>
      <Header />
        <Routes>
          <Route path={"/"} element={<Home />}/>
          <Route path={"/about"} element={<About />}/>
          <Route path={"/add-book"} element={<AddBook />} />
          <Route path={"/books"} element={<Books/>}/>
        </Routes>
      </QueryClientProvider>
    </div>
  )
}

export default App
