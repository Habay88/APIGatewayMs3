import { useState,useEffect } from "react";
import User from '../../model/user';
import {useSelector} from 'react-redux';
import{useNavigate,navigate} from 'react-router-dom';
import AuthenticationService from '../../services/authentication.service';
const RegisterPage = ()=>{

    const [user,setUser]= useState(new User('','',''));
    const [Loading,setLoading]=useState(false);
    const[submitted,setSubmitted]= useState(false);
    const[errorMessage,setErrorMessage]=useState('');
    const currentUser = useSelector(state => state.user);
//mounted
useEffect( ()=>{
    if(currentUser?.id){
        navigate('/profile');
    }

},[]
);
const handleChange =(e)=>{
    const {name, value}= e.target;

    setUser((prevState =>{
        return{
            ...prevState,
            [name]: value
        };
    }));
}
const handleRegister =()=>{
    setSubmitted(true);
    //validation
    if(!user.username || !user.password || !user.name){
        return;
    }
    setLoading(true);
    AuthenticationService.register(user).then(_ =>{
       navigate('/login');
        }
    }).catch(error =>{
        console.log(error);
        if(error?.response?.status === 409){
            setErrorMessage('username or password is not valid');
        } else{
            setErrorMessage('unexpected error occured.');
        }
    })
};
    return (
        <p>Register Page</p>
    )
}

export {RegisterPage};