import axios from 'axios';

const FLIGHT_API_BASE_URL = "http://localhost:9001";

class RegistrationService {

    userRegistration(userData){
        return axios.post(FLIGHT_API_BASE_URL +"/subs", userData);
    }
}

export default new RegistrationService()