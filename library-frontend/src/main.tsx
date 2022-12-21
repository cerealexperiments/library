import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { QueryClient, QueryClientProvider } from "react-query";
import Root from "./pages/Root";
import Home from "./pages/Home";
import Books from "./pages/Books";
import { UserType } from "./types";
import About from "./pages/About";
import Profile from "./pages/Profile";
import {AuthProvider} from "./context/AuthContext";
import SignUp from "./pages/SignUp";
import SignIn from "./pages/SignIn";
import AddBook from "./pages/AddBook";
import Favorites from "./pages/Favorites";

const queryClient = new QueryClient();


const router = createBrowserRouter([
  {
    path: "/",
    element: <Root/>,
    children: [
      {
        index: true,
        element: <Home/>
      },
      {
        path: "/books",
        element: <Books />
      },
      {
        path: "/profile",
        element: <Profile />
      },
      {
        path: "/about",
        element: <About/>
      },
      {
        path: "/signup",
        element: <SignUp/>
      },
      {
        path: "/signin",
        element: <SignIn/>
      },
      {
        path: "/favorites",
        element: <Favorites/>
      },
      {
        path: "/add",
        element: <AddBook />
      }
    ]
  }
]);

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
      <AuthProvider>
        <RouterProvider router={router}/>
      </AuthProvider>
    </QueryClientProvider>
  </React.StrictMode>,
)
