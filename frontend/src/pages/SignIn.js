import React from 'react'
import SignInForm from '../components/SignInForm'

const SignIn = ({ setUser }) => {
  return (
    <div>
      SignIn
      <SignInForm setUser={setUser} />
    </div>
  )
}

export default SignIn
