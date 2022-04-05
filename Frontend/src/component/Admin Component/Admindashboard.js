import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css'

export default class Admindashboard extends Component {
  addFlight() {
    window.location.href="/addflight";
    
  }
  viewFlight(){
    window.location.href="/flightcrud";
  }
  addVacancy(){
    window.location.href="/addvacancy";
  }
  Logout = (e1) =>{
    //e1.preventDefault()
    alert("Logged out successfully!")
    window.location.href="/home";
}
  render() {
    return (
      <div>
        <nav className="navbar navbar-expand-lg navbar-light" style={{backgroundColor: "#25bbcc"}}>
  <div className="container-fluid">
    <a className="navbar-brand" href="/">Home</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarText">
      <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        <li>
        <button type="button" className="btn btn-dark" onClick={this.Logout}>Logout</button>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div style={{backgroundColor:"#a3ed9f",height:"570px"}}>
  <h1 style={{color:"#e88017"}}>Admin Dashboard</h1>
  <br />
  <button style={{width:"200px"}} type="button" className="btn btn-primary btn-lg" onClick={() => this.addFlight()}>Add Flight</button><br /><br />
<button style={{width:"200px"}} type="button" className="btn btn-primary btn-lg" onClick={() => this.viewFlight()}>View Flights</button><br /><br />
<button style={{width:"200px"}} type="button" className="btn btn-primary btn-lg" onClick={() => this.addVacancy()}>Add vaccancy</button><br /><br />
</div>
<br />

      </div>
    );
  }
}
