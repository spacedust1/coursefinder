# coursefinder Android Application (NIT3213 Final Assignment)
[![image1.jpg](https://i.postimg.cc/65NhDRZG/image1.jpg)](https://postimg.cc/8stWv7t1)

## Overview

CourseFinder is an Android application designed to demonstrate proficiency in API integration, user interface design, and Android development best practices. The app features three main screens: Login, Dashboard, and Details, and interacts with the `vu-nit3213-api` for user authentication and data retrieval.

## Features

- **Login Screen**: 
- Allows users to authenticate, only using their username and password. 🔐
[![pic1.jpg](https://i.postimg.cc/43nMmtBx/pic1.jpg)](https://postimg.cc/R35GYWkk)
- **Dashboard Screen**: 
- Displays a list of entities (courses) retrieved from the API. Click functionality navigates to the Details screen.
[![pic3.jpg](https://i.postimg.cc/hvnpb7bx/pic3.jpg)](https://postimg.cc/8JyRTcYP)
- **Details Screen**: 
- Shows detailed information about the selected entities.
[![pic2.jpg](https://i.postimg.cc/8zZ9pwdY/pic2.jpg)](https://postimg.cc/qNCjQs5c)

## API Details

### Base URL

`https://vu-nit3213-api.onrender.com`

### Endpoints

1. **Login Endpoint**

   - **URL**: `/ort/auth`
   - **Method**: POST
   - **Request Body**:
     ```json
     {
       "username": "Yusuf",
       "password": "s4517856"
     }
     ```
   - **Successful Response**:
     ```json
     {
       "keypass": "courses"
     }
     ```

2. **Dashboard Endpoint**

   - **URL**: `/dashboard/courses`
   - **Method**: GET
   - **Successful Response**:
     ```json
     {
       "entities": [
        {
            "courseCode": "CS101",
            "courseName": "Introduction to Programming",
            "instructor": "Dr. Smith",
            "credits": 3,
            "description": "A foundational course covering basic programming concepts and problem-solving techniques."
        }, ...
        // More objects...
      
     }
     ```
## Dependencies ✨ 

-   ```bash
    Hilt/ Retrofit/ AndroidX Libraries
    ```

## Instructions 🚀

1. Clone the repository:
   ```bash
   https://github.com/spacedust1/coursefinder.git
   ```
2. Navigate to the project directory:
   ```bash
   \coursefinder
   ```
3. Build and Run the application using Android Studio.





----
This project was made for NIT3213 Final Assignment by Yusuf Servare S4517856

---