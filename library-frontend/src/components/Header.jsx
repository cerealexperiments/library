import React from "react";
import styles from "./Header.module.css";
import { FaSearch } from "react-icons/fa";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <div className={styles.header}>
      <h1 className={styles.logo}>
        <Link className={styles.logoLink} to="/">
          Library
        </Link>
      </h1>
      <nav className={styles.navigation}>
        <Link to="/about" className={styles.navLink}>
          About
        </Link>
        <Link to="/add" className={styles.navLink}>
          Add Book
        </Link>
        <Link to="/books" className={styles.navLink}>
          Books
        </Link>
      </nav>
      <div className={styles.buttonsBox}>
        <div className={styles.searchBox}>
          <input
            type="text"
            placeholder="Search book here..."
            className={styles.search}
          />
          <FaSearch className={styles.searchIcon} />
        </div>
        <button className={styles.createAccount}>Create Account</button>
      </div>
    </div>
  );
}

export default Navbar;
