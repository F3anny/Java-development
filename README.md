# Spring Security Demo - Signup & Login

A complete Spring Boot application demonstrating Spring Security with user registration and login functionality.

## Features

- ✅ User registration with validation
- ✅ Secure password encryption (BCrypt)
- ✅ Form-based authentication
- ✅ Protected routes
- ✅ Beautiful, modern UI
- ✅ H2 in-memory database (perfect for learning)

## Prerequisites

- Java 17 or higher
- Maven 3.6+

## How to Run

1. **Clone or navigate to the project directory**

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application:**
   - Open your browser and go to: `http://localhost:8080`
   - You'll be redirected to the login page

## Usage

1. **Sign Up:**
   - Click "Sign up here" on the login page
   - Fill in username, email, and password
   - Click "Sign Up"

2. **Login:**
   - Use your registered username and password
   - Click "Login"

3. **View Database (Optional):**
   - Access H2 console at: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: (leave empty)

## Project Structure

```
src/
├── main/
│   ├── java/com/example/security/
│   │   ├── config/
│   │   │   └── SecurityConfig.java          # Spring Security configuration
│   │   ├── controller/
│   │   │   ├── AuthController.java          # Login & Signup endpoints
│   │   │   └── HomeController.java          # Protected home page
│   │   ├── dto/
│   │   │   └── UserRegistrationDto.java     # Registration form data
│   │   ├── entity/
│   │   │   └── User.java                    # User entity
│   │   ├── repository/
│   │   │   └── UserRepository.java          # User data access
│   │   ├── service/
│   │   │   └── UserService.java             # Business logic & UserDetailsService
│   │   └── SpringSecurityDemoApplication.java
│   └── resources/
│       ├── static/css/
│       │   └── style.css                    # Styling
│       ├── templates/
│       │   ├── login.html                   # Login page
│       │   ├── signup.html                  # Signup page
│       │   └── home.html                    # Protected home page
│       └── application.properties           # Configuration
```

## Key Spring Security Concepts Demonstrated

1. **SecurityFilterChain**: Configures which URLs are public vs protected
2. **PasswordEncoder**: BCrypt for secure password hashing
3. **UserDetailsService**: Loads user data for authentication
4. **DaoAuthenticationProvider**: Handles authentication logic
5. **Form Login**: Custom login page with form-based authentication
6. **Role-based Access**: Users have roles (ROLE_USER)

## Learning Points

- How Spring Security intercepts requests
- How to configure public vs protected routes
- How to implement custom login/signup pages
- How password encryption works
- How to integrate with JPA/Hibernate
- How to use Thymeleaf with Spring Security

## Next Steps to Learn More

- Add email verification
- Implement "Remember Me" functionality
- Add password reset feature
- Implement OAuth2 (Google, GitHub login)
- Add role-based authorization (ADMIN, USER)
- Implement JWT tokens for REST API authentication

## Notes

- This uses H2 in-memory database, so data is lost on restart
- For production, replace H2 with PostgreSQL/MySQL
- CSRF is disabled for H2 console (only for learning)

Enjoy learning Spring Security! 🚀
