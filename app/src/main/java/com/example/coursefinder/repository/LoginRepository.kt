package com.example.coursefinder.repository

import com.example.coursefinder.network.ApiService
import com.example.coursefinder.datamodels.LoginRequest
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(username: String, password: String): Result<String> {
        return try {
            val request = LoginRequest(username, password)
            val response = apiService.login(request)
            if (response.isSuccessful) {
                Result.success(response.body()?.keypass ?: "Unknown")
            } else {
                Result.failure(Exception("Login failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
