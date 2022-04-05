import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css'
import FlightService from "./FlightService";

export default class AddVacancy extends Component {
    state = {
        flightId: "",
        available: "",
      };

      onHandleChange = (event) => {
        this.setState({
          [event.target.name]: event.target.value,
        });
      };

      onSubmit = (e) =>{
        e.preventDefault()
        let addData = this.state;
        console.log("submitted",addData);
        JSON.stringify(addData)
        console.log('userData => ' + JSON.stringify(addData));
        FlightService.addVacancy(addData).then(res =>{
            console.log("res", res);
            alert("Seat added!")
            window.location.href="/admindashboard";
    
        });
    }
    onCancel = (e1) =>{
        e1.preventDefault()
        window.location.href="/admindashboard";
    }
  render() {
    return (
        <div>
             <div className="homecontainer">
            <div className="navigation-home">
              <a href="/admindashboard">Back</a>
            </div>
            </div>
      <div style={{height:"500px",width:"200px" ,marginLeft:"300px" , marginTop:"60px"}}>
        <form>
          <div style={{width:"350px"}} className="form-outline mb-4">
            <label className="form-label" htmlFor="form2Example1">
              FlightId
            </label>
            <input type="text" id="form2Example1" className="form-control" name="flightId" value={this.state.flightId} onChange={this.onHandleChange}/>
          </div>
          <div style={{width:"350px"}} className="form-outline mb-4">
            <label className="form-label" htmlFor="form2Example1">
            Seats
            </label>
            <input type="text" id="form2Example1" className="form-control" name="available" value={this.state.available} onChange={this.onHandleChange}/>
          </div>
          <button style={{width:"350px"}} type="submit" className="btn btn-primary btn-block mb-4" value="Submit" onClick={this.onSubmit}>
            Add
          </button>
          <button style={{width:"350px"}} type="submit" className="btn btn-danger btn-block mb-4" value="Submit" onClick={this.onCancel}>
            Cancel
          </button>
        </form>
      </div>
      </div>
    );
  }
}
