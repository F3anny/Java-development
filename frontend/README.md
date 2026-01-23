# Spring Security Frontend

React frontend application integrated with Spring Security backend.

## Features

- ✅ User registration
- ✅ User login
- ✅ Protected routes
- ✅ Authentication state management
- ✅ Modern, responsive UI
- ✅ API integration with backend

## Setup

1. **Install dependencies:**
   ```bash
   cd frontend
   npm install
   ```

2. **Start the development server:**
   ```bash
   npm run dev
   ```

3. **Access the application:**
   - Frontend: http://localhost:5173
   - Backend API: http://localhost:8095

## Project Structure

```
frontend/
├── src/
│   ├── components/
│   │   ├── Login.jsx          # Login component
│   │   ├── Signup.jsx         # Signup component
│   │   ├── Home.jsx           # Protected home page
│   │   ├── ProtectedRoute.jsx # Route protection
│   │   ├── Auth.css           # Auth styling
│   │   └── Home.css           # Home styling
│   ├── context/
│   │   └── AuthContext.jsx     # Authentication context
│   ├── services/
│   │   └── api.js             # API service layer
│   ├── App.jsx                # Main app component
│   ├── main.jsx               # Entry point
│   └── index.css              # Global styles
├── package.json
├── vite.config.js
└── README.md
```

## API Integration

The frontend communicates with the backend through:
- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login
- `POST /api/auth/logout` - User logout
- `GET /api/auth/me` - Get current user
- `GET /api/home` - Protected home endpoint

## Development

- **Frontend runs on:** http://localhost:5173
- **Backend runs on:** http://localhost:8095
- **Proxy configured:** API calls are proxied through Vite

Make sure both frontend and backend are running for full functionality!
