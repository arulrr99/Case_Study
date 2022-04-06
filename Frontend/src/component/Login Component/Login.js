import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css'
import LoginService from "./LoginService";

export default class Login extends Component {
  state = {
    username: "",
    password: "",
  };
  
  onHandleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };
  onSubmit = (e) => {
    e.preventDefault();
    let loginData = this.state;
    console.log("submitted", loginData);
    console.log("userData => " + JSON.stringify(loginData));
   
    LoginService.login(loginData).then((res) => {
      console.log("res", res);
      if (res.data.response) {
        localStorage.removeItem("user");
        localStorage.setItem("user", JSON.stringify(res.data.response));
      
      }
      if(res.data.role===null){
        alert("Invalid login credentials");
      }
     
      if(res.data.role==="admin"){
        alert("Login success!");
        window.location.href="/admindashboard";
      }
       if(res.data.role==="user"){
        alert("Login success!");
        window.location.href="/userdashboard";
      }
      
    });
    
  };
  render() {
    return (
      <div>
           <div className="homecontainer">
            <div className="navigation-home">
              <a href="/home">Home</a>
            </div>
            </div>
        <section className="vh-100" style={{ backgroundColor: "#92d4d4" }}>
          <div className="container py-5 h-100">
            <div className="row d-flex justify-content-center align-items-center h-100">
              <div className="col-12 col-md-8 col-lg-6 col-xl-5">
                <div
                  className="card shadow-2-strong"
                  style={{ borderRadius: "1rem" }}
                >
                  <div className="card-body p-5 text-center">
                    <h3 className="mb-5">Sign in</h3>
                    <div className="form-outline mb-4">
                      <input
                        type="email"
                        id="typeEmailX-2"
                        className="form-control form-control-lg"
                        name="username"
                        value={this.state.username} onChange={this.onHandleChange}
                      />
                      <label className="form-label" htmlFor="typeEmailX-2">
                        Email
                      </label>
                    </div>
                    <div className="form-outline mb-4">
                      <input
                        type="password"
                        id="typePasswordX-2"
                        className="form-control form-control-lg"
                        name="password"
                        value={this.state.password} onChange={this.onHandleChange}
                      />
                      <label className="form-label" htmlFor="typePasswordX-2">
                        Password
                      </label>
                    </div>
                    {/* Checkbox */}
                    <div className="form-check d-flex justify-content-start mb-4">
                      <input
                        className="form-check-input"
                        type="checkbox"
                        defaultValue
                        id="form1Example3"
                      />
                      <label
                        className="form-check-label"
                        htmlFor="form1Example3"
                      >
                        {" "}
                        Remember password{" "}
                      </label>
                    </div>
                   
                    <button
                      className="btn btn-primary btn-lg btn-block"
                      type="submit"
                      name="submit"
                      value="submit" onClick={this.onSubmit}
                    >
                      Login
                    </button>
                    <p className="text-center text-muted mt-5 mb-0">Don't have an account? <a href="/signup" className="fw-bold text-body"><u>Register here</u></a></p>
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    );
  }
}
