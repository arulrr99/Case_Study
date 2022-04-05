import React, { Component } from 'react'
import BookingService from './BookingService';

export default class Book extends Component {

    state = {
        flightId: "",
        firstname: "",
        lastname: "",
        noOfPassengers: ""
      };
    
      onHandleChange = (event) => {
        this.setState({
          [event.target.name]: event.target.value,
        });
      };

      onSubmit = (e) =>{
        e.preventDefault()
        let passengerData = this.state;
        console.log("submitted",passengerData);
        JSON.stringify(passengerData)
        console.log('userData => ' + JSON.stringify(passengerData));
      
    
        BookingService.passengerBooking(passengerData).then(res =>{
            console.log("res", res);
            if(res.data==="Seats Not Avaliable"){
              alert(res.data);
            }
            else{
              alert("Seats booked successfully");
              alert(res.data);
              alert("Complete your payment now!"); 
              window.location.href="/payment";
            }
    
        });
    }
    onCancel = (e1) =>{
      e1.preventDefault()
      window.location.href="/userdashboard";
  }
  Logout=(e2)=>{
    alert("Looged out successfully!")
    window.location.href="/home";
  }


  render() {
    return (
      <div>
                <nav
        className="navbar navbar-expand-lg navbar-light"
        style={{ backgroundColor: "#227cd6" }}
      >
        <div className="container-fluid">
          <a className="navbar-brand" href="/userdashboard">
            User Dashboard
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarText"
            aria-controls="navbarText"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarText">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li>
                <button type="button" className="btn btn-dark" onClick={this.Logout}>
                  Logout
                </button>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div style={{ backgroundColor: "#f0f0f0", height: "800px" }}>
        {/* <h1 style={{ color: "#e88017" }}>User Dashboard</h1> */}
        <br />
        <div>
          <form
            style={{
              backgroundColor: "#7ed3f2",
              width: "500px",
              marginLeft: "400px",
            }}
          >
            <h3>Enter passenger details</h3>
            <br />
            <div className="form-group" style={{textAlign:"left"}}>
              <label htmlFor="exampleInputPassword1"></label>
              <input
                type="text"
                className="form-control"
                id="exampleInputPassword1"
                name="flightId"
                placeholder="Flight Id"
                value={this.state.flightId} onChange={this.onHandleChange}
              />
            </div>
            <br />
            <div className="form-group">
              <input
                type="text"
                className="form-control"
                id="exampleInputPassword1"
                name="firstname"
                placeholder="First Name"
                value={this.state.firstname} onChange={this.onHandleChange}
              />
            </div>
            <br />
            <div className="form-group">
              <input
                type="text"
                className="form-control"
                id="exampleInputPassword1"
                name="lastname"
                placeholder="Last Name"
                value={this.state.lastname} onChange={this.onHandleChange}
              />
            </div>
            <br />
            <div className="form-group">
              <input
                type="text"
                className="form-control"
                id="exampleInputPassword1"
                name="noOfPassengers"
                placeholder="No. of passengers"
                value={this.state.noOfPassengers} onChange={this.onHandleChange}
              />
            </div>
            <br />
            <button type="submit" className="btn btn-primary" value="Submit" onClick={this.onSubmit}> 
              Book now{" "}
            </button>
            <button type="submit" className="btn btn-danger" value="Submit" onClick={this.onCancel}> 
              Cancel
            </button>
            
          </form>
          <br />
          <br />
          <br />
         
        </div>
      </div>
      </div>
    )
  }
}
