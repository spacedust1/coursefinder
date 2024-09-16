package com.example.coursefinder.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coursefinder.network.ApiService
import com.example.coursefinder.datamodels.LoginRequest
import com.example.coursefinder.datamodels.LoginResponse
import com.example.coursefinder.datamodels.Course
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    private val _loginResult = MutableLiveData<Result<LoginResponse>>()
    val loginResult: LiveData<Result<LoginResponse>> = _loginResult

    private val _coursesResult = MutableLiveData<Result<List<Course>>>()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val request = LoginRequest(username, password)
            try {
                val response: Response<LoginResponse> = apiService.login(request)
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        _loginResult.value = Result.success(loginResponse)
                        fetchCourses() //
                    } else {
                        _loginResult.value = Result.failure(Exception("Authentication failed"))
                    }
                } else {
                    _loginResult.value = Result.failure(Exception("Login failed"))
                }
            } catch (e: Exception) {
                _loginResult.value = Result.failure(e) } } }

    private fun fetchCourses() {
        viewModelScope.launch {
            try {
                val response = apiService.getCourses() //
                if (response.isSuccessful) {
                    val courseList = response.body()?.entities
                    if (courseList != null) {
                        _coursesResult.postValue(Result.success(courseList))
                    } else {
                        _coursesResult.postValue(Result.failure(Exception("Courses response empty")))
                    }
                } else {
                    _coursesResult.postValue(Result.failure(Exception("Courses fetch failed: ${response.message()}")))
                }
            } catch (e: Exception) {
                _coursesResult.postValue(Result.failure(e))
            } } } }
