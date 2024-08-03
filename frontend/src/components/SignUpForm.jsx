import React from 'react'

import {useForm} from 'react-hook-form'

import '../styles/signUpForm.css'

import {Navigate, useNavigate} from 'react-router-dom'

import { RegisterUser } from '../services/UserService'

const SignUpForm = () => {
  const navigate = useNavigate()
  const { register, handleSubmit, watch, formState: { errors } } = useForm();

  const onSubmit = async (data) => {
    // console.log(data)
    if(data.role === "Community Advocate"){
      await RegisterUser({...data, isAdvocate: true })
    } else {
      await RegisterUser({...data, advocate: false})
    }
    navigate('/')
  };

  return (
    <div className='formCtn'>
      <form onSubmit={handleSubmit(onSubmit)} className="form">
        <input placeholder='Username' {...register("username")} className="inputVal"/>
        <input placeholder='First Name' {...register("firstName")} className="inputVal"/>
        <input placeholder='Last Name' {...register("lastName")} className="inputVal"/>
        <input placeholder='Email'{...register("email")} className="inputVal"/>
        <input placeholder='Password'{...register("passwordHash")} className="inputVal"/>
        <input placeholder='Location'{...register("userLocation")} className="inputVal"/>
        <select {...register("role")} className="selectBtn">
          <option value="Community Advocate">Community Advocate</option>
          <option value="Community Member">Community Member</option>
        </select>
        <button type="submit" className='signUpBtn'>Submit</button>
      </form>
    </div>
  )
}

export default SignUpForm

// {
//   "username": "TheGuy",
//   "passwordHash": "superSecret",
//   "firstName": "Ant",
//   "lastName": "Brodie",
//   "role": "user",
//   "email": "email.gmail",
//   "userLocation": "Ohio",
//   "advocate": true
// }