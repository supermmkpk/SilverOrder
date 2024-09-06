import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';
import NavLogo from '../../logo/NavLogo.png';
const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="navbar-left">
        <div className="navbar-logo">
          <img src={NavLogo} alt="Logo" className="nav-logo" />
        </div>
        <div className="navbar-links">
          <Link to="/menu" className="nav-link">MENU</Link>
          <Link to="/order" className="nav-link">ORDER</Link>
          <Link to="/review" className="nav-link">REVIEW</Link>
          <Link to="/dashboard" className="nav-link">DASHBOARD</Link>
        </div>
      </div>
      
      <div className="navbar-right">
        <button className="bell-button">
          <i className="fa fa-bell" aria-hidden="true"></i>
        </button>
        <button className="logout-button">LOGOUT</button>
      </div>
    </nav>
  );
};

export default Navbar;
