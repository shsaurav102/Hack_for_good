import React from 'react'

function UserHome() {

    const initialState = {
        name: 'Test',
        role: 'advocate',
    }

    

  return (
    <div>UserHome Testing
        <h1>test</h1>
        <h1>Hi {initialState.name}</h1>


    </div>
  )
}

export default UserHome