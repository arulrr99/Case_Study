import React, { Component } from "react";
import RegistrationService from "./RegistrationService";

const regExp = RegExp(/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/);

const formValid = ({ isError, ...rest }) => {
  let isValid = false;

  Object.values(isError).forEach((val) => {
    if (val.length > 0) {
      isValid = false;
    } else {
      isValid = true;
    }
  });

  Object.values(rest).forEach((val) => {
    if (val === null) {
      isValid = false;
    } else {
      isValid = true;
    }
  });

  return isValid;
};
export default class Register extends Component {
  state = {
    username: "",
    password: "",
    usernameError: false,
    passwordError: false,
    isError: {
      username: "",
      password: "",
    },
  };

  onHandleChange = (event) => {
    const value = event.target.value;
    const name = event.target.name;
    this.setState({
      [name]: value,
    });
    let isError = { ...this.state.isError };

    switch (name) {
      case "username":
        isError.username = regExp.test(value) ? "" : "Email address is invalid";
        break;
      case "password":
        isError.password =
          value.length < 6 ? "Atleast 6 characaters required" : "";
        break;
      default:
        break;
    }

    this.setState({
      isError,
      [name]: value,
    });

    if (name === "username") {
      if (value === "" || value === null) {
        this.setState({
          usernameError: true,
        });
      } else {
        this.setState({
          usernameError: false,
          name: value,
        });
      }
    }

    if (name === "password") {
      if (value === "" || value === null) {
        this.setState({
          passwordError: true,
        });
      } else {
        this.setState({
          passwordError: false,
          name: value,
        });
      }
    }
  };

  onSubmit = (e) => {
    e.preventDefault();
    if (formValid(this.state)) {
      console.log(this.state);
    } else {
      console.log("Form is invalid!");
    }
    if (this.state.username === "" || this.state.password === "") {
      if (this.state.username === "") {
        this.setState({
          usernameError: true,
        });
      }
      if (this.state.password === "") {
        this.setState({
          passwordError: true,
        });
      }
    } else {
      let registerData = this.state;
      console.log("submitted", registerData);
      JSON.stringify(registerData);
      console.log("userData => " + JSON.stringify(registerData));

      RegistrationService.userRegistration(registerData).then((res) => {
        console.log("res", res);
        alert("Registered Successfully! Log in to access the site!");
        window.location.href = "/login";
      });
    }
  };
  render() {
    const { isError } = this.state;
    return (
      <div>
        <div className="homecontainer">
          <div className="navigation-home">
            <a href="/home">Home</a>
          </div>
        </div>
        <section
          className="vh-100 bg-image"
          style={{ backgroundColor: "#92d4d4" }}
        >
          <div className="mask d-flex align-items-center h-100 gradient-custom-3">
            <div className="container h-100">
              <div className="row d-flex justify-content-center align-items-center h-100">
                <div className="col-12 col-md-9 col-lg-7 col-xl-6">
                  <div className="card" style={{ borderRadius: "15px" }}>
                    <div className="card-body p-5">
                      <h2 className="text-uppercase text-center mb-5">
                        Create an account
                      </h2>

                      <form>
                        <div className="form-outline mb-4">
                          <label
                            className="form-label"
                            htmlFor="form3Example3cg"
                          >
                            Your Username
                          </label>
                          <input
                            type="email"
                            id="form3Example3cg"
                            name="username"
                            // className="form-control form-control-lg"
                            className={
                              isError.username.length > 0
                                ? "is-invalid form-control"
                                : "form-control form-control-lg"
                            }
                            placeholder="xyz@gmail.com"
                            value={this.state.username}
                            onChange={this.onHandleChange}
                            required
                          />
                          {isError.username.length > 0 && (
                            <span className="invalid-feedback">
                              {isError.username}
                            </span>
                          )}
                          {this.state.usernameError ? (
                            <label style={{ float: "right" }}>
                              <span className="pink-text">
                                <b>username field is empty !!!</b>
                              </span>
                            </label>
                          ) : (
                            ""
                          )}
                        </div>

                        <div className="form-outline mb-4">
                          <label
                            className="form-label"
                            htmlFor="form3Example4cg"
                          >
                            Password
                          </label>
                          <input
                            type="password"
                            id="form3Example4cg"
                            name="password"
                            // className="form-control form-control-lg"
                            className={
                              isError.password.length > 0
                                ? "is-invalid form-control"
                                : "form-control form-control-lg"
                            }
                            value={this.state.password}
                            onChange={this.onHandleChange}
                            required
                          />
                          {isError.password.length > 0 && (
                            <span className="invalid-feedback">
                              {isError.password}
                            </span>
                          )}
                          {this.state.passwordError ? (
                            <label style={{ float: "right" }}>
                              <span className="pink-text">
                                <b>password field is empty !!!</b>
                              </span>
                            </label>
                          ) : (
                            ""
                          )}
                        </div>
                        <div className="d-flex justify-content-center">
                          <button
                            type="button"
                            className="btn btn-success btn-block btn-lg gradient-custom-4 text-body"
                            value="Submit"
                            onClick={this.onSubmit}
                          >
                            Register
                          </button>
                        </div>

                        <p className="text-center text-muted mt-5 mb-0">
                          Have already an account?{" "}
                          <a href="/login" className="fw-bold text-body">
                            <u>Login here</u>
                          </a>
                        </p>
                      </form>
                    </div>
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
