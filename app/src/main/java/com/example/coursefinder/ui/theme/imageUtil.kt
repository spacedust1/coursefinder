package com.example.coursefinder.ui.theme

import com.example.coursefinder.R

object imageUtil {

    fun getImageForCourse(courseCode: String): Int {
        return when (courseCode) {
            "CS101" -> R.drawable.codingpic
            "MATH201" -> R.drawable.calcpic
            "BIO101" -> R.drawable.geneticpic
            "ENG105" -> R.drawable.writingpic
            "PHYS301" -> R.drawable.quantumpic
            "BIO202" -> R.drawable.geneticpic
            "CHEM101" -> R.drawable.chempic
            "PSYCH205" -> R.drawable.psypic
            else -> R.drawable.ic_action
    }
}}
