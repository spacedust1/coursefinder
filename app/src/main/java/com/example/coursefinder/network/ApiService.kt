package com.example.coursefinder.network

import com.example.coursefinder.datamodels.CourseApiResponse
import com.example.coursefinder.datamodels.Course
import com.example.coursefinder.datamodels.LoginRequest
import com.example.coursefinder.datamodels.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    // Method to authenticate
    @POST("/ort/auth")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    // Get courses
    @GET("/dashboard/courses")
    suspend fun getCourses(): Response<CourseApiResponse>
}
