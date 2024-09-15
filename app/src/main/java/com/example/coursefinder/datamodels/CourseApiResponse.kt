package com.example.coursefinder.datamodels

data class CourseApiResponse(
    val entities: List<Course>,
    val entityTotal: Int
)

