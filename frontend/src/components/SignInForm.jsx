import { useNavigate } from 'react-router-dom'
import { useState } from "react"
import { SigninUser } from '../services/UserService'

const SignInForm = ({ setUser }) => {
    const navigate = useNavigate()

    const initialState = {
        username: '',
        passwordHash: '',
    }

    const [formValues, setFormValues] = useState (initialState)

    const handleChange = (e) => {
        setFormValues({ ...formValues, [e.target.name]: e.target.value })
        console.log(formValues)
    }

    const handleSubmit = async (e) => {
        e.preventDefault()
        
        const user = await SigninUser(formValues)
        // const user = {
        //     "username": formValues.username,
        //     "passwordHash": formValues.passwordHash,
        //     "firstName": "josh",
        //     "lastName": "Levine",
        //     "role": "advocate",
        //     "email":"josh@josh.com",
        //     "userLocation": "Ohio",
        //     "isAdvocate": true
        // }

          setUser(user)
          setFormValues(initialState)
          navigate('/userhome')
        // }
    }

    //js code

  return (
    <div>
        <h1>SignInForm</h1>
        <form onSubmit={handleSubmit}> 
            <div>
                <label htmlFor="name-input">Username:</label>
                <input onChange={handleChange} id="name-input" name="username" type="text" />
            </div>
            <div>
                <label htmlFor="email-input">Password:</label>
                <input onChange={handleChange} id="email-input" name="passwordHash" type="password" />
            </div>
            <div>
                <button disabled = {!formValues.username || !formValues.passwordHash}>Sign In</button>
            </div>
        </form>
    </div>
    

  )
}

export default SignInForm