import axios from "axios";
const FLIGHT_API_BASE_URL = "http://localhost:9001";

class LoginService {

    login(loginData){
        return axios.post(FLIGHT_API_BASE_URL +"/auth", loginData);
    }
}

export default new LoginService()