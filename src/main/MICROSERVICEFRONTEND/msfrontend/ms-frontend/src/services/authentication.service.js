import { BASE_API_URL } from "../common.js/Common";
import axios from "axios"
const BASE_URL= BASE_API_URL + 'api/authentication';
class AuthenticationService{

    login(user){
    return axios.post(BASE_URL + '/sign-in',user);
    }

    register(user){
        return axios.post('/signup',user);
    }

}
export default new AuthenticationService();