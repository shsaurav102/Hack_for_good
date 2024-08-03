import { useNavigate } from 'react-router-dom'

const UserHome = ({ user }) => {
  const navigate = useNavigate()

  const navToProfile = () => {
    navigate('/userhome/profile')
  }

  return (
    <div>
      <div>UserHome</div>
      <div>{user.username}</div>
      <button onClick={navToProfile}>User Profile</button>
    </div>
  )
}

export default UserHome
