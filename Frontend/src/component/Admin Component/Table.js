import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

import FlightService from "./FlightService";



export default class Table extends Component {
  state = {
    flights: [],
  };

  componentDidMount() {
    FlightService.getFlight().then((res) => {
      this.setState({ flights: res.data });
      console.log(res);
    });
  }
  deleteFlight(id) {
    console.log(id);
    FlightService.deletFlight(id).then((res) => {
      console.log(res);
      alert(res.data);
      window.location.reload();
    });
  }

  updateFlight(flightId) {
    console.log(flightId);
    window.location.href="/updateflight";
  }
  render() {
    return (
      <div>
        <div className="homecontainer">
            <div className="navigation-home">
              <a href="/admindashboard">Back</a>
            </div>
            </div>
        <a
          href="/addflight"
          style={{ marginLeft: "10px", marginTop: "20px" }}
          className="btn btn-primary"
        >
          {" "}
          Add Flight
        </a>
        <br />
        <br />
        <table
          className="table table-striped table-hover table-bordered"
          style={{ width: "900px", marginLeft: "150px" }}
        >
          <thead>
            <tr>
              <th scope="col">Number</th>
              <th scope="col">Id</th>
              <th scope="col">Departure</th>
              <th scope="col">Destination</th>
              <th scope="col">Price</th>
              <th scope="col">Date</th>
              <th scope="col">Book</th>
            </tr>
          </thead>
          <tbody>
            {this.state.flights.map((flight,i) => (
              <tr>
                <th scope="row">{i+1}</th>
                <td>{flight.flightId}</td>
                <td>{flight.departure}</td>
                <td>{flight.destination}</td>
                <td>{flight.price}</td>
                <td>{flight.date}</td>
                <td>
                  <button
                    onClick={() => this.updateFlight(flight.flightId)}
                    className="btn btn-info"
                  >
                    Edit{" "}
                  </button>
                  <button
                    style={{ marginLeft: "10px" }}
                    className="btn btn-danger"
                    onClick={() => this.deleteFlight(flight.flightId)}
                  >
                    Delete{" "}
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}
