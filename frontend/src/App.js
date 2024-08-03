import { Route, Routes } from 'react-router-dom'
import './App.css'
import SignIn from './pages/SignIn'
import SignUp from './pages/SignUp'
import UserHome from './pages/UserHome'
import ProfilePage from './pages/ProfilePage'
import { useState } from 'react'

function App() {
  const [user, setUser] = useState(null)

  const publicRoutes = (
    <Route path="/">
      <Route index element={<SignIn setUser={setUser} />} />
      <Route path="/register" element={<SignUp />} />
    </Route>
  )
  // const user = false

  const authorizedRoutes = (
    <Route path="/">
      <Route index element={<UserHome user={user} />} />
      <Route path="/userhome" element={<UserHome user={user} />} />
      <Route path="/userhome/profile" element={<ProfilePage user={user} />} />

      {/* <Route index element={<UserHome user={user} />} /> */}
      {/* <Route path="/register" element={<SignUp/>}/>
      <Route path="*" element={<NotFound/>}/> */}
    </Route>
  )
  return (
    <div className="App">
      {/* <Navbar/> // not completed yet */}
      <Routes>{user ? authorizedRoutes : publicRoutes}</Routes>
    </div>
  )
}

export default App
