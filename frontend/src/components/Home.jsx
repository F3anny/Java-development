import { useAuth } from '../context/AuthContext'
import { homeAPI } from '../services/api'
import { useState, useEffect } from 'react'
import './Home.css'

const Home = () => {
  const { user, logout } = useAuth()
  const [homeData, setHomeData] = useState(null)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    fetchHomeData()
  }, [])

  const fetchHomeData = async () => {
    try {
      const data = await homeAPI.getHome()
      setHomeData(data)
    } catch (err) {
      console.error('Error fetching home data:', err)
    } finally {
      setLoading(false)
    }
  }

  const handleLogout = async () => {
    await logout()
    window.location.href = '/login'
  }

  return (
    <div className="home-container">
      <div className="home-card">
        <h1>Welcome to Spring Security Demo!</h1>
        
        {loading ? (
          <p>Loading...</p>
        ) : (
          <>
            <div className="user-info">
              <p>Hello, <strong>{user?.username || homeData?.username || 'User'}</strong>!</p>
              <p>You are successfully logged in.</p>
            </div>

            <div className="info-box">
              <h2>What you've learned:</h2>
              <ul>
                <li>✅ User registration with password encryption</li>
                <li>✅ Form-based authentication</li>
                <li>✅ Spring Security configuration</li>
                <li>✅ User details service implementation</li>
                <li>✅ Protected routes and access control</li>
                <li>✅ React frontend integration</li>
                <li>✅ REST API communication</li>
              </ul>
            </div>

            <button onClick={handleLogout} className="btn btn-secondary">
              Logout
            </button>
          </>
        )}
      </div>
    </div>
  )
}

export default Home
