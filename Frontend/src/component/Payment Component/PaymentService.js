import axios from "axios";

const FLIGHT_API_BASE_URL = "http://localhost:9004/razorpayment";

class PaymentService {

    createOrder(Data){
        return axios.post(FLIGHT_API_BASE_URL +"/create_order", Data);
    }
}

export default new PaymentService()