import React, { Component } from "react";
import PaymentService from "./PaymentService";

export default class PaymentOpen extends Component {
  state = {
     amount:""
  };

  onHandleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

componentDidMount() {
    const script = document.createElement("script");
    script.src = "https://checkout.razorpay.com/v1/checkout.js";
    script.async = true;
    document.body.appendChild(script);
  }

  onSubmit = (e) => {
    e.preventDefault();
    let orderDetail = {"amount":this.state.amount};

    PaymentService.createOrder(orderDetail).then((res) => {
        console.log("PAYMENT ORDER RESPONSE", res);
        var options = {
            "key": "rzp_test_KNg1IH9YfE4WlP", // Enter the Key ID generated from the Dashboard
            "amount": res.data.amount, 
            "currency": "INR",
            "name": "Flight Booking",
            "description": "Seat Reservation",
            // "image": "https://example.com/your_logo",
            "order_id":res.data.id, 
            "handler": function (response){
                console.log(response);
                alert("Payment Successfull !!!");
                window.location.href="/userdashboard";
            },
            "prefill": {
                "name": "",
                "email": "",
                "contact": ""
            },
            "notes": {
                "address": "Flight Booking System"
            },
            "theme": {
                "color": "#26a69a"
            }
        };
        var rzp1 = new window.Razorpay(options);
        rzp1.open();
      });
  };
  
  render() {
    return (
      <div>
        <form style={{
              backgroundColor: "#84e3e0",
              width: "500px",
              height:"400px",
              marginLeft: "400px",
              marginTop:"150px"
            }}>
                <br />
                <br />
          <div className="form-outline mb-4">
          <label className="form-label" htmlFor="form2Example1">
              Enter amount
            </label>
            <input type="text" id="form2Example1" className="form-control" placeholder="in Rupees" name="amount" value={this.state.amount} onChange={this.onHandleChange}/>
          </div>
          <button type="button" className="btn btn-success btn-block mb-4" onClick={this.onSubmit}>
            Procced to pay
          </button>

         
        </form>
      </div>
    );
  }
}
