import axios from 'axios';

const FLIGHT_API_BASE_URL = "http://localhost:9002/user";

class BookingService{
    passengerBooking(passengerData){
        return axios.post(FLIGHT_API_BASE_URL+"/adduser",passengerData)
    }
}
export default new BookingService();