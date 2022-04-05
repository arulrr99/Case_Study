import React, { Component } from "react";
import "./Home.css";

export default class Home extends Component {
  render() {
    return (
      <div>
        <div className="home">
          <div className="homecontainer">
            <div className="navigation-home">
              <a href="/home">Home</a>
              <a href="/login">Login</a>
              <a href="/signup">SignUp</a>
            </div>
          </div>
          <br />
          <br />
          <br />
          <div>
            <h1 className="greet">Welcome to flight booking!</h1>
            </div>
        </div>
        
         
      </div>
    );
  }
}
