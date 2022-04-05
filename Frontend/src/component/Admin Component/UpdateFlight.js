import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css'
import FlightService from "./FlightService";


export default class UpdateFlight extends Component {
    state = {
        flightId: "",
        departure: "",
        destination: "",
        price: "",
        date: "",
      };

      componentDidMount(){
        console.log(this.props.id);
          console.log("Id",this.state.flightId);
          if(this.state.flightId){
              this.editFlight(this.state.flightId);
          }
      }

    //   editFlight(Id){
    //       FlightService.getFlightById(Id).then((res)=>{
    //           console.log(res);
    //           this.setState({
    //               departure:res.data.departure,
    //               destination:res.data.destination,
    //               price:res.data.price,
    //               date:res.data.date
    //           });
    //       });
    //   }

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
        
    
        FlightService.addFlight(addData).then(res =>{
            console.log("res", res);
            window.location.href="/flightcrud";
    
        });
    }
    onCancel = (e1) =>{
        e1.preventDefault()
        window.location.href="/flightcrud";
    }
  render() {
    return (
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
            Departure
            </label>
            <input type="text" id="form2Example1" className="form-control" name="departure" value={this.state.departure} onChange={this.onHandleChange}/>
          </div>


          <div style={{width:"350px"}} className="form-outline mb-4">
            <label className="form-label" htmlFor="form2Example2">
              Destination
            </label>
            <input type="text" id="form2Example2" className="form-control" name="destination" value={this.state.destination} onChange={this.onHandleChange}/>
          </div> 
          <div style={{width:"350px"}} className="form-outline mb-4">
            <label className="form-label" htmlFor="form2Example2">
              Price
            </label>
            <input type="text" id="form2Example2" className="form-control" name="price" value={this.state.price} onChange={this.onHandleChange}/>
          </div>
          <div style={{width:"350px"}} className="form-outline mb-4">
            <label className="form-label" htmlFor="form2Example2">
              Date
            </label>
            <input type="date" id="form2Example2" className="form-control" name="date" value={this.state.date} onChange={this.onHandleChange}/>
          </div>
          
    
          <button style={{width:"350px"}} type="submit" className="btn btn-primary btn-block mb-4" value="Submit" onClick={this.onSubmit}>
            Update
          </button>
          <button style={{width:"350px"}} type="submit" className="btn btn-danger btn-block mb-4" value="Submit" onClick={this.onCancel}>
            Cancel
          </button>
        </form>
      </div>
    );
  }
}
